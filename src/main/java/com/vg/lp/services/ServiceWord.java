package com.vg.lp.services;

import com.vg.lp.datalayer.BasicsDAO;
import com.vg.lp.datalayer.EndingsDAO;
import com.vg.lp.datalayer.InformationDAO;
import com.vg.lp.datalayer.MorphologicalDAO;
import com.vg.lp.datalayer.data.word.Word;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceWord {
    private BasicsDAO basicsDAO;
    private EndingsDAO endingsDAO;
    private MorphologicalDAO morphDAO;
    private InformationDAO infoDAO;

    private static final Logger logger = Logger.getLogger(ServiceWord.class);

    public ServiceWord(BasicsDAO basicsDAO, EndingsDAO endingsDAO, MorphologicalDAO morphDAO, InformationDAO infoDAO) {
        this.basicsDAO = basicsDAO;
        this.endingsDAO = endingsDAO;
        this.morphDAO = morphDAO;
        this.infoDAO = infoDAO;
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
        if (endings.isEmpty()){
            return simpleWord;  //нулевое окончание у слова
        } else {
            List<String> basics = basicsDAO.getAllBasics();
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

    public Word getWord(String simpleWord){
        Word word = new Word();
        word.setWord(simpleWord);

        List<String> getRightEndings = getRightEndings(simpleWord);
        logger.info("Список всех возможных окончаний для слова \"" + simpleWord + "\": "
                + getRightEndings.stream().reduce(" ",(log, ending) -> log + ending + " ") );

        String basic = getBasics(simpleWord, getRightEndings);
        word.setBasic(basic);
        logger.info("Основа слова \"" + simpleWord + "\": " + basic);

        

        return word;
    }
}
