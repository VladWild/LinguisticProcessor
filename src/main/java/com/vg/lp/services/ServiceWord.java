package com.vg.lp.services;

import com.vg.lp.datalayer.BasicsDAO;
import com.vg.lp.datalayer.EndingsDAO;
import com.vg.lp.datalayer.InformationDAO;
import com.vg.lp.datalayer.MorphologicalDAO;
import com.vg.lp.datalayer.data.Specifications;
import com.vg.lp.datalayer.data.word.Word;
import com.vg.lp.persers.specifications.ParserSps;
import com.vg.lp.persers.text.Parser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceWord {
    private BasicsDAO basicsDAO;
    private EndingsDAO endingsDAO;
    private MorphologicalDAO morphDAO;
    private InformationDAO infoDAO;

    private Parser parser;
    private ParserSps parserSps;

    private static final Logger logger = Logger.getLogger(ServiceWord.class);

    public ServiceWord(BasicsDAO basicsDAO, EndingsDAO endingsDAO, MorphologicalDAO morphDAO, InformationDAO infoDAO) {
        this.basicsDAO = basicsDAO;
        this.endingsDAO = endingsDAO;
        this.morphDAO = morphDAO;
        this.infoDAO = infoDAO;
    }

    @Autowired
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    @Autowired
    public void setParserSps(ParserSps parserSps) {
        this.parserSps = parserSps;
    }

    private boolean isEndingNull(String ending){
        return ending.equals("ending");
    }

    //получаем все возможные окончания для введенного слова (кроме нулевого)
    private List<String> getRightEndings(String simpleWord){
        return endingsDAO.getAllEndings().stream()
                .filter(simpleWord::endsWith)
                .collect(Collectors.toList());
    }

    //получение основы слова по списку возможных окончаний
    private String getBasics(String simpleWord, List<String> endings){
        List<String> basics = basicsDAO.getAllBasics();
        if (endings.isEmpty() || basics.contains(simpleWord)){
            return simpleWord;  //нулевое окончание у слова
        } else {
            for (String ending : endings) {
                String possibleBasic = simpleWord
                        .substring(0, simpleWord.length() - ending.length());
                if (basics.contains(possibleBasic)){
                    return possibleBasic;
                }
            }
            return null;
        }
    }

    //определяем окончание по исходному слову и его основе
    private String getEnding(String simpleWord, String basic){
        if (simpleWord.equals(basic)) {
            return "null";
        } else {
            return simpleWord.substring(basic.length(), simpleWord.length());
        }
    }

    public Word getWord(String simpleWord){
        Word word = new Word();
        word.setWord(simpleWord);

        List<String> getRightEndings = getRightEndings(simpleWord);
        logger.info("Список всех возможных окончаний для слова \"" + simpleWord + "\": "
                + getRightEndings.stream().reduce(" ",(log, ending) -> log + ending + " ") );

        String basic = getBasics(simpleWord, getRightEndings);
        word.setBasic(basic);
        logger.info("Основа слова \"" + simpleWord + "\": " + basic);

        String ending = getEnding(simpleWord, basic);
        word.setEnding(ending);
        logger.info("Окончание слова \"" + simpleWord + "\": " + ending);

        int numberBasics = basicsDAO.getIdByBasic(basic);
        logger.info("Номер флективного класса - основы слова \"" + simpleWord + "\": " + numberBasics + " - " + basic);
        int numberEnding = endingsDAO.getIdByEndings(ending);
        logger.info("Номер окончания слова \"" + simpleWord + "\": " + numberEnding + " - " + ending);

        String morphData = morphDAO.getMorphologicalInfo(numberBasics, numberEnding);
        List<String> ids = parser.getList(morphData);
        logger.info("Номера морфологических признаков: " + ids.stream().reduce("", (log, v) -> log + v + ", "));

        List<Specifications> sps = infoDAO.getSpecifications(ids.stream().map(Integer::valueOf).collect(Collectors.toList()));
        word.setTypeWord(parserSps.getTypeWord(sps));
        logger.info("Часть речи слова \"" + simpleWord + "\": " + word.getTypeWord().getType());

        word.setSigns(parserSps.getSpes(sps));
        logger.info("Характеристики слова \"" + simpleWord + "\": " + word.getSigns());

        return word;
    }
}




