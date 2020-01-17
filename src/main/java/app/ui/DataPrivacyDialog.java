//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package app.ui;

import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class DataPrivacyDialog {

    private static Object[] options = { "Akzeptieren", "Verweigern" };

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

    /*public static JDialog createStatusDialog(String msg, String title) {
        JFrame frame = new JFrame(title);
        JOptionPane pane = new JOptionPane();
        pane.setMessage(msg);
        JDialog dialog = pane.createDialog(frame, title);
        return dialog;
    }*/

    public static void showStatusDialog(String title, String msg){
        JTextArea area = new JTextArea(5, 70);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setText(msg);

        JOptionPane.showMessageDialog(null, area, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getCustomDataPrivacyMessage(String id){
        String msg = "<h1><b>Vielen Dank f\u00fcr die Teilnahme an dieser Studie.</h1>"+
                "<p>Sobald Sie die Datenschutzerkl\u00e4rung akzeptiert haben, werden die geloggten Daten auf den Server hochgeladen. <br>"+
                "Im Anschluss werden Sie zu einem Google Formular weitergeleitet, in dem Sie sich 0,25 Versuchspersonenstunden gutschreiben lassen k\u00f6nnen.<br><br>"+
                "Daf\u00fcr ben\u00f6tigen Sie den <b>Best\u00e4tigungscode OOP-1337.</b> Bitte merken Sie sich diesen Code oder schreiben Sie Ihn sich auf.</p>"+
                "<h2>Datenschutzerkl\u00e4rung</h2>" +
                "<p>Sie haben ein Plugin f\u00fcr die Entwicklungsumgebung IntelliJ verwendet." +
                "Durch die Nutzung wurden Interaktionsdaten aufgezeichnet<br>" +
                "und auf einem Webserver des Lehrstuhls f\u00fcr Medieninformatik gespeichert. </p>" +
                "<p>Bitte best\u00e4tigen Sie, dass diese Daten in anonymisierter Form ausgewertet " +
                "und im Rahmen von Forschungsarbeiten verwendet werden d\u00fcrfen.<br>"+
                "Die erhobenen Daten werden im Rahmen von Forschungsarbeiten " +
                "des Lehrstuhls f\u00fcr Medieninformatik und kooperierenden Forschungspartnern verwendet.</p>" +
                "<p>Zu keinem Zeitpunkt sind oder werden die Daten mit Hinweisen zu Ihrer Person verkn\u00fcpft. <br>" +
                "Auswertungen erfolgen vollst\u00e4ndig anonymisiert.</p>" +
                "<p>Bei der Aufzeichnung der Daten in der Entwicklungsumgebung wird eine eindeutige ID (UUID) erzeugt,<br>" +
                "die mit den Logdaten auf den Server \u00fcbertragen wird. <br>" +
                "Eine Identifikation des verwendeten Rechners oder Ihrer Person ist zu keinem Zeitpunkt m\u00f6glich.<br>" +
                "Weitere Identifikationsdaten wurden nicht aufzeichnet.</p>"+
                "<p>Aufgezeichnete Daten:<br>" +
                "<ul><li>UUID zur Identifikation der Datens\u00e4tze </li>" +
                "<li>Verwendete Men\u00fceintr\u00e4ge </li>" +
                "<li>Verwendete IDE-Funktionen</li></ul></p>"+
                "<p>Ihre ID: "+ id + "</p>";

        return new String(msg.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }

}
