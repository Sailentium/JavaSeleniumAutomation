package helpers;

import org.apache.commons.lang3.StringUtils;

import java.util.ResourceBundle;

public class Common {
    public static String getChromeVersion() {
        String env = System.getProperty("chromeVersion");
        if (StringUtils.isEmpty(env)) {
            env = getConfigValue("chromeVersion");
        }
        return env;
    }

    public static String getConfigValue(String key) {
        ResourceBundle config = ResourceBundle.getBundle("config");
        return config.getString(key);
    }
}
