package com.vladislavgusev.linguisticprocessor.runners;

import com.vladislavgusev.linguisticprocessor.datalayer.EndingsDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SQLiteTest {
    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        EndingsDAO endingsDAO = (EndingsDAO) context.getBean("SQLiteEndingDAO");

        String k = endingsDAO.info();
        System.out.println(k);
    }
}

