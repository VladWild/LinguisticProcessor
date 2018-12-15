package com.vg.lp.utilities.requestmanagers;

import java.io.IOException;
import java.util.Properties;

public class QuestionManager implements Manager {
    private static final String NAME_PROPERTY_FILE = "database\\questions.properties";

    private Properties properties;

    private QuestionManager() throws IOException {
        this.properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(NAME_PROPERTY_FILE));
    }

    @Override
    public String getRequest(String key) {
        return properties.getProperty(key);
    }
}
