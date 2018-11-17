package com.vladislavgusev.linguisticprocessor;

import com.vladislavgusev.linguisticprocessor.utilities.ResourceMenu;
import org.apache.log4j.Logger;

import java.io.IOException;

public class LinguisticProcessor {
    private static final Logger logger = Logger.getLogger(LinguisticProcessor.class);

    private void run(){
        logger.debug("Инициализация менаджера \"Resource Menu\"");
        ResourceMenu manager = null;
        try {
            manager = ResourceMenu.getInstance();
        } catch (IOException e) {
            logger.error("Ошибка в инициализации менаджера: Exception: " + e.toString());
            return;
        }

        String question = manager.getString("question");

    }

    public static void main(String[] args) {
        logger.info("Приложение \"Linguistic Processor\" стартовало");
        LinguisticProcessor phoneBook = new LinguisticProcessor();

        logger.debug("Приложение \"Linguistic Processor\" запустилось");
        phoneBook.run();
    }
}
