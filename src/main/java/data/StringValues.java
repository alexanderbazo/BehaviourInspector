package data;

public interface StringValues {
    /* Logging */
    String LOG_TITLE = "Behaviour Inspector";
    String UPLOAD_SERVER_URL = "http://regensburger-forscher.de:9999/upload/";
    String CONFIRMATION_FORM_URL = "https://docs.google.com/forms/d/e/1FAIpQLScIV6Z_CMR13WKAvi3tVJgNH8U8PXWqUU4nj1HfSQJva53txA/viewform?usp=pp_url&entry.683205857=$ID";

    /* Notifications */
    String PLUGIN_RUNNING_STATUS = "Plugin wurde gestartet";
    String PLUGIN_STOPPED_STATUS = "Plugin wurde beendet";
    String PLUGIN_RUNNING_BAR = "Aufzeichung der Interaktionsdaten l\u00E4uft. ";
    String SESSION_RUNNING_TEXT = "Das Plugin läuft: Interaktionsdaten werden aufgezeichnet";

    /* Menu */
    String START_SESSION_TEXT = "Sitzung aufzeichnen";
    String SAVE_SESSION_TEXT = "Sitzung speichern";

    /* Confirmation */
    String CONFIRMATION_DATA_SECURITY_TITLE = "Datenschutzerkl\u00E4rung";
    String DATA_PRIVACY_ACCEPT_OPTION = "Akzeptieren";
    String DATA_PRIVACY_DECLINE_OPTION = "Verweigern";
    String DATA_PRIVACY_MESSAGE = "<div style=\"font-family: sans-serif\"><h1><b>Vielen Dank f\u00fcr die Teilnahme an dieser Studie.</h1>"+
            "<p>Sobald Sie die Datenschutzerkl\u00e4rung akzeptiert haben, werden die geloggten Daten auf den Server hochgeladen. "+
            "Im Anschluss werden Sie zu einem Google Formular weitergeleitet, in dem Sie sich 0,25 Versuchspersonenstunden gutschreiben lassen k\u00f6nnen.</p>"+
            "<h2>Datenschutzerkl\u00e4rung</h2>" +
            "<p>Sie haben ein Plugin f\u00fcr die Entwicklungsumgebung IntelliJ verwendet. " +
            "Durch die Nutzung wurden Interaktionsdaten aufgezeichnet und auf einem Webserver des Lehrstuhls f\u00fcr Medieninformatik gespeichert.</p>" +
            "<p>Bitte best\u00e4tigen Sie durch das Akzeptieren dieser Erklärung, dass diese Daten in anonymisierter Form ausgewertet und im Rahmen von Forschungsarbeiten verwendet werden d\u00fcrfen.</p>"+
            "<p>Die erhobenen Daten werden im Rahmen von Forschungsarbeiten des Lehrstuhls f\u00fcr Medieninformatik und kooperierenden Forschungspartnern verwendet." +
            "Zu keinem Zeitpunkt sind oder werden die Daten mit Hinweisen zu Ihrer Person verkn\u00fcpft. Auswertungen erfolgen vollst\u00e4ndig anonymisiert. " +
            "Bei der Aufzeichnung der Daten in der Entwicklungsumgebung wird eine eindeutige ID (<code>UUID</code>) erzeugt, die zusammen mit den Logdaten auf den Server \u00fcbertragen wird.</p>" +
            "<p><b>Eine Identifikation des verwendeten Rechners oder Ihrer Person ist zu keinem Zeitpunkt m\u00f6glich.</b> Weitere Identifikationsdaten wurden nicht aufgezeichnet.</p>"+
            "<h3>Umfang der aufgezeichneten Daten:</h3>" +
            "<ul><li>UUID zur Identifikation der Datens\u00e4tze ($ID)</li>" +
            "<li>Verwendete Men\u00fceintr\u00e4ge </li>" +
            "<li>Verwendete IDE-Funktionen</li></ul>";
    String DATA_PRIVACY_DECLINED_TITLE = "Ihre Daten werden nicht verwendet";
    String DATA_PRIVACY_DECLINED_MESSAGE = "<div style=\"font-family: sans-serif\"><h1>Ihre Daten werden nicht verwendet</h1><p>Sie haben der Datenschutzerkl\u00E4rung widersprochen.\nDie aufgezeichneten Interaktionsdaten werden <b>nicht auf den Server hochgeladen</b> und werden automatisch gel\u00f6scht, sobald Sie sich von dem CIP-Pool-Rechner abmelden. <p>Sollten Sie Ihren eigenen Rechner verwendet haben, l\u00f6schen Sie bitte den Ordner <code>.OOP-Plugin</code> in Ihrem Benutzerverzeichnis.</p></div>";
}
