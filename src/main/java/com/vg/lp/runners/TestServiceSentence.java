package com.vg.lp.runners;

import com.vg.lp.datalayer.data.word.Word;
import com.vg.lp.persers.text.Parser;
import com.vg.lp.persers.world.ParserWord;
import com.vg.lp.services.ServiceSentence;
import com.vg.lp.utilities.requestmanagers.Manager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestServiceSentence {
    private ApplicationContext context =
            new ClassPathXmlApplicationContext("spring/context.xml");

    private void testSimpleParserWorld(){
        Parser ps = (Parser) context.getBean("sentParser");
        ParserWord pw = (ParserWord) context.getBean("simpleParserWord");

        List<Word> words = pw.getList(ps.getList("Как между собой сыграли Россия и Испания?"));

        ServiceSentence ss = (ServiceSentence) context.getBean("serviceSentence");
        ss.getListGroups(words);
    }

    public static void main(String[] args) {
        TestServiceSentence tss = new TestServiceSentence();

        //System.out.println("РМПСОБPKКСЗK".contains("РМПСОБP"));

        tss.testSimpleParserWorld();
    }
}
