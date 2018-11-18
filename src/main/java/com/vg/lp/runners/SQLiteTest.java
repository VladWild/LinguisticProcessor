package com.vg.lp.runners;

import com.vg.lp.datalayer.BasicsDAO;
import com.vg.lp.datalayer.EndingsDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SQLiteTest {

    private void testEnding(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/dao-context.xml");
        EndingsDAO endingsDAO = (EndingsDAO) context.getBean("sqliteEndingDAO");

        endingsDAO.getAllEndings().forEach(System.out::println);
    }

    private void testBasics(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/dao-context.xml");
        BasicsDAO basicsDAO = (BasicsDAO) context.getBean("sqliteBasicsDAO");

        basicsDAO.getAllEndings().forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        SQLiteTest sqLiteTest = new SQLiteTest();

        sqLiteTest.testEnding();
        sqLiteTest.testBasics();


    }
}



