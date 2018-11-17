package com.vladislavgusev.linguisticprocessor;

import org.apache.log4j.Logger;

public class LinguisticProcessor {
    private static final Logger logger = Logger.getLogger(LinguisticProcessor.class);

    private void run(){

    }

    public static void main(String[] args) {
        logger.info("Приложение \"Linguistic Processor\" стартовало");
        LinguisticProcessor phoneBook = new LinguisticProcessor();

        logger.debug("Приложение \"Linguistic Processor\" запустилось");
        phoneBook.run();
    }
}


