package com.mai.guofeng.model;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class MaiProperties {
    public static void main(String[] args) {

        M2();

    }

    public static void M1() throws IOException {
        // InputStream in = new BufferedInputStream(new FileInputStream("application"));
        Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");
        // Properties properties = new Properties();
        // properties.load(in);
        String a = properties.getProperty("spring.profiles.active");
        System.out.println(a);
    }

    public static void M2() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        String a = resourceBundle.getString("spring.profiles.active");
        System.out.println(a);
    }
}
