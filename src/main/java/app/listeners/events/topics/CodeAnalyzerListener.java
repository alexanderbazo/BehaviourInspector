package app.listeners.events.topics;

import app.inspectors.HighlightInfoInspector;
import app.listeners.events.base.BaseListener;
import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer;
import com.intellij.codeInsight.daemon.impl.DaemonCodeAnalyzerImpl;
import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class CodeAnalyzerListener extends BaseListener implements DaemonCodeAnalyzer.DaemonListener {

    private Project currentProject;
    private HighlightInfoInspector.HighlightInfoInspectorResults lastResults;

    public CodeAnalyzerListener(Project project) {
        super("CodeAnalyzer");
        currentProject = project;
    }

    @Override
    public void daemonStarting(@NotNull Collection<FileEditor> fileEditors) {
    }

    @Override
    public void daemonFinished() {
    }

    @Override
    public void daemonFinished(@NotNull Collection<FileEditor> fileEditors) {
        analyzeCurrentErrors();
    }

    @Override
    public void daemonCancelEventOccurred(@NotNull String reason) {

    }

    private void analyzeCurrentErrors() {
        Document document = FileEditorManager.getInstance(currentProject).getSelectedTextEditor().getDocument();
        List<HighlightInfo> highlightInfoList = DaemonCodeAnalyzerImpl.getHighlights(document, HighlightSeverity.INFORMATION, currentProject);
        HighlightInfoInspector.HighlightInfoInspectorResults results = HighlightInfoInspector.inspectHighlightList(highlightInfoList);
        if(results.equals(lastResults)) {
            return;
        }
        log(results.toString());
        lastResults = results;
    }
}
