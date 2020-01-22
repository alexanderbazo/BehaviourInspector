//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package app.ui.dataprivacy;

import com.intellij.ui.components.JBScrollPane;
import data.StringValues;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class DataPrivacyDialog implements StringValues {

    private static Object[] options = { DATA_PRIVACY_ACCEPT_OPTION, DATA_PRIVACY_DECLINE_OPTION };

    public DataPrivacyDialog() {
    }

    public static SecurityResponse showConfirmationDialog(String id, String title) {
        String msg = getCustomDataPrivacyMessage(id);
        JEditorPane editorPane = new JEditorPane("text/html", msg);
        editorPane.setEditable(false);
        JBScrollPane scrollPane = new JBScrollPane(editorPane);
        editorPane.setCaretPosition(0);
        scrollPane.setPreferredSize(new Dimension(500,500));
        int result = JOptionPane.showOptionDialog(null, scrollPane, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
        return SecurityResponse.values()[result];
    }

    public static void showStatusDialog(String title, String msg){
        JEditorPane editorPane = new JEditorPane("text/html", msg);
        editorPane.setEditable(false);
        JBScrollPane scrollPane = new JBScrollPane(editorPane);
        editorPane.setCaretPosition(0);
        scrollPane.setPreferredSize(new Dimension(500,200));
        JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getCustomDataPrivacyMessage(String id){
        String msg = DATA_PRIVACY_MESSAGE.replace("$ID", id);
        return new String(msg.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }

}
