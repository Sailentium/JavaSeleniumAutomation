package helpers;

import java.util.ResourceBundle;

public class Common {
    public static String getChromeVersion() {
        return getConfigValue("chromeVersion");
    }

    public static String getConfigValue(String key) {
        ResourceBundle config = ResourceBundle.getBundle("config");
        return config.getString(key);
    }
}
