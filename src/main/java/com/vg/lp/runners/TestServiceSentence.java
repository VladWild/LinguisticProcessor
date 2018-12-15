package com.vg.lp.runners;

import com.vg.lp.persers.text.Parser;
import com.vg.lp.persers.world.ParserWord;
import com.vg.lp.utilities.requestmanagers.Manager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestServiceSentence {
    private ApplicationContext context =
            new ClassPathXmlApplicationContext("spring/context.xml");

    private void testSimpleParserWorld(){
        Parser ps = (Parser) context.getBean("sentParser");
        ParserWord pw = (ParserWord) context.getBean("simpleParserWord");

        pw.getList(ps.getList("Как между собой сыграли Россия и Испания?"));
    }

    public static void main(String[] args) {
        TestServiceSentence tss = new TestServiceSentence();

        tss.testSimpleParserWorld();

    }
}
