package com.vg.lp.runners;

import com.vg.lp.datalayer.data.word.Word;
import com.vg.lp.persers.text.Parser;
import com.vg.lp.persers.world.ParserWord;
import com.vg.lp.services.ServiceGetQuestion;
import com.vg.lp.services.ServiceSentence;
import com.vg.lp.services.ServiceTypeQuestion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestServiceSentence {
    private ApplicationContext context =
            new ClassPathXmlApplicationContext("spring/context.xml");

    private void testSimpleParserWorld(){
        Parser ps = (Parser) context.getBean("sentParser");
        ParserWord pw = (ParserWord) context.getBean("simpleParserWord");

        List<Word> words = pw.getList(ps.getList("сколько матчей сыграла Португалия?"));

        ServiceSentence ss = (ServiceSentence) context.getBean("serviceSentence");
        String number = ss.getListGroups(words);

        ServiceTypeQuestion stq = (ServiceTypeQuestion) context.getBean("stq");
        int type = stq.getTypeQuestion(number);
        System.out.println();

        ServiceGetQuestion sgq = (ServiceGetQuestion) context.getBean("sgq");
        sgq.getQuestion(words, type);
    }

    public static void main(String[] args) {
        TestServiceSentence tss = new TestServiceSentence();

        tss.testSimpleParserWorld();
    }
}


