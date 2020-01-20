package data;

public interface Values {

    String LOG_TITLE = "Behaviour Inspector";

    String UPLOAD_SERVER_URL = "http://regensburger-forscher.de:9999/upload/";
    String CONFIRMATION_FORM_URL = "https://docs.google.com/forms/d/e/1FAIpQLScIV6Z_CMR13WKAvi3tVJgNH8U8PXWqUU4nj1HfSQJva53txA/viewform?usp=pp_url&entry.683205857=$ID";

    String PLUGIN_RUNNING_STATUS = "Plugin wurde gestartet";
    String PLUGIN_STOPPED_STATUS = "Plugin wurde beendet";
    String PLUGIN_RUNNING_BAR = "Plugin Behaviour Inspector l\u00E4uft. Bitte zum Ende der \u00dcbung vor Beenden der IDE das Plugin beenden.";

    String CONFIRMATION_DATA_SECURITY_TITLE = "Datenschutzerkl\u00E4rung";

    String DATA_PRIVACY_DECLINED_TITLE = "Fehlende Zustimmung";
    String DATA_PRIVACY_DECLINED_MESSAGE = "Sie haben der Datenschutzerkl\u00E4rung widersprochen.\nDie aufgezeichneten Interaktionsdaten werden nicht auf den Server hochgeladen und sind gel\u00f6scht, sobald Sie sich von diesem PC abmelden.";
}
