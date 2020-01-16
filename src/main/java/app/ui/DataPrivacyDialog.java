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

    private static Object[] options = { "Zustimmen", "Daten l\u00f6schen",
            "Abbrechen" };

    public DataPrivacyDialog() {
    }

    public static SecurityResponse showConfirmationDialog(String id, String title) {
        String msg = getCustomDataPrivacyMessage(id);

        JTextArea textArea = new JTextArea(30, 70);
        textArea.setText(msg);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setCaretPosition(0);

        JBScrollPane scrollPane = new JBScrollPane(textArea);

        int result = JOptionPane.showOptionDialog(null, scrollPane, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        return SecurityResponse.values()[result];
    }

    public static JDialog createStatusDialog(String msg, String title) {
        JFrame frame = new JFrame(title);
        JOptionPane pane = new JOptionPane();
        pane.setMessage(msg);
        JDialog dialog = pane.createDialog(frame, title);
        return dialog;
    }

    public static void showStatusDialog(String title, String msg){
        JTextArea area = new JTextArea(10, 70);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setText(msg);

        JOptionPane.showMessageDialog(null, area, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getCustomDataPrivacyMessage(String id){
        String msg = "Sie haben ein Plugin f\u00fcr die Entwicklungsumgebung IntelliJ verwendet. " +
                "Durch die Nutzung wurden Interaktionsdaten aufgezeichnet und auf einem Webserver " +
                "des Lehrstuhls f\u00fcr Medieninformatik gespeichert. \n\n" +
                "Bitte best\u00e4tigen Sie, dass diese Daten in anonymisierter Form ausgewertet " +
                "und im Rahmen von Forschungsarbeiten verwendet werden d\u00fcrfen.\n"+
                "Die erhobenen Daten werden im Rahmen von Forschungsarbeiten " +
                "des Lehrstuhls f\u00fcr Medieninformatik und kooperierenden Forschungspartnern verwendet. \n\n" +
                "Zu keinem Zeitpunkt sind oder werden die Daten mit Hinweisen zu Ihrer Person verkn\u00fcpft. \n" +
                "Auswertungen erfolgen vollst\u00e4ndig anonymisiert. \n\n" +
                "Bei der Aufzeichnung der Daten in der Entwicklungsumgebung wird eine eindeutige ID (UUID) erzeugt,\n" +
                "die mit den Logdaten auf den Server \u00fcbertragen wird. \n" +
                "Eine Identifikation des verwendeten Rechners oder Ihrer Person ist zu keinem Zeitpunkt m\u00f6glich.\n" +
                "Weitere Identifikationsdaten wurden nicht aufzeichnet.\n\n"+
                "Aufgezeichnete Daten:\n" +
                "- UUID zur Identifikation der Datens\u00e4tze\n" +
                "- Verwendete Men\u00fceintr\u00e4ge\n" +
                "- Verwendete IDE-Funktionen\n\n"+
                "ID: "+ id +
                "\n\nBitte best\u00E4tigen Sie, dass die durch Sie generierten Interaktionsdaten anonymisiert" +
                " im Rahme von Forschungsvorhaben verwendet werden d\u00fcrfen.\n";

        return new String(msg.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }

}
