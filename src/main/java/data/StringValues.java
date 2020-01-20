package data;

public interface StringValues {
    /* Logging */
    String LOG_TITLE = "Behaviour Inspector";
    String UPLOAD_SERVER_URL = "http://regensburger-forscher.de:9999/upload/";
    String CONFIRMATION_FORM_URL = "https://docs.google.com/forms/d/e/1FAIpQLScIV6Z_CMR13WKAvi3tVJgNH8U8PXWqUU4nj1HfSQJva53txA/viewform?usp=pp_url&entry.683205857=$ID";

    /* Notifications */
    String PLUGIN_RUNNING_STATUS = "Plugin wurde gestartet";
    String PLUGIN_STOPPED_STATUS = "Plugin wurde beendet";
    String PLUGIN_RUNNING_BAR = "Plugin Behaviour Inspector l\u00E4uft. Daten werden aufgezeichnet.";
    String SESSION_RUNNING_TEXT = "Das Plugin läuft: Interaktionsdaten werden aufgezeichnet";

    /* Menu */
    String START_SESSION_TEXT = "Sitzung aufzeichnen";
    String SAVE_SESSION_TEXT = "Sitzung speichern";

    /* Confirmation */
    String CONFIRMATION_DATA_SECURITY_TITLE = "Datenschutzerkl\u00E4rung";
    String DATA_PRIVACY_ACCEPT_OPTION = "Akzeptieren";
    String DATA_PRIVACY_DECLINE_OPTION = "Verweigern";
    String DATA_PRIVACY_MESSAGE = "<h1><b>Vielen Dank f\u00fcr die Teilnahme an dieser Studie.</h1>"+
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
            "<p>Ihre ID: $ID</p>";
    String DATA_PRIVACY_DECLINED_TITLE = "Fehlende Zustimmung";
    String DATA_PRIVACY_DECLINED_MESSAGE = "Sie haben der Datenschutzerkl\u00E4rung widersprochen.\nDie aufgezeichneten Interaktionsdaten werden nicht auf den Server hochgeladen und sind gel\u00f6scht, sobald Sie sich von diesem PC abmelden.";
}
