package com.vg.lp.runners;

import com.vg.lp.datalayer.BasicsDAO;
import com.vg.lp.datalayer.EndingsDAO;
import com.vg.lp.datalayer.InformationDAO;
import com.vg.lp.datalayer.MorphologicalDAO;
import com.vg.lp.services.ServiceWord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SQLiteTestServiceWord {

    private void testEnding(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/dao-context.xml");
        EndingsDAO endingsDAO = (EndingsDAO) context.getBean("sqliteEndingDAO");

        endingsDAO.getAllEndings().forEach(System.out::println);
        System.out.println(endingsDAO.getIdByEndings("и"));
    }

    private void testBasics(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/dao-context.xml");
        BasicsDAO basicsDAO = (BasicsDAO) context.getBean("sqliteBasicsDAO");

        basicsDAO.getAllBasics().forEach(System.out::println);
        System.out.println(basicsDAO.getIdByBasic("Росси"));
    }

    private void testMorphological() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/dao-context.xml");
        MorphologicalDAO morphologicalDAO = (MorphologicalDAO) context.getBean("sqliteMorphologicalDAO");

        System.out.println(morphologicalDAO.getMorphologicalInfo(1,2));
    }

    private void testInformation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/dao-context.xml");
        InformationDAO informationDAO = (InformationDAO) context.getBean("sqliteInformationDAO");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);

        informationDAO.getSpecifications(list).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/dao-context.xml");

        SQLiteTestServiceWord sqLiteTest = new SQLiteTestServiceWord();

        //sqLiteTest.testEnding();
        //sqLiteTest.testBasics();
        //sqLiteTest.testMorphological();
        //sqLiteTest.testInformation();

        ServiceWord serviceWord = (ServiceWord) context.getBean("serviceWord");
        serviceWord.getWord("стадии");
    }


}



