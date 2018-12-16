package com.vg.lp.services;

import com.vg.lp.datalayer.DataDAO;
import com.vg.lp.datalayer.data.getting.ResultMatch;
import com.vg.lp.datalayer.data.getting.Teams;
import com.vg.lp.datalayer.data.word.Word;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceGetQuestion {
    private DataDAO dataDAO;

    public ServiceGetQuestion(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    public void getQuestion(List<Word> words, int type){
        switch (type) {
            case 1:
                List<String> teams = words.stream()
                        .filter(word -> word.getMetka().equals("К"))
                        .map(Word::getBasic).collect(Collectors.toList());
                ResultMatch rm = (ResultMatch) dataDAO.getResultMatch(teams);
                System.out.println("Счет матча: " + rm.getTeam1Goals() + "-" + rm.getTeam2Goals());
                break;
            case 2:
                List<String> win = words.stream()
                        .filter(word -> word.getMetka().equals("P+"))
                        .map(Word::getBasic).collect(Collectors.toList());
                List<String> defeat = words.stream()
                        .filter(word -> word.getMetka().equals("P-"))
                        .map(Word::getBasic).collect(Collectors.toList());
                if (!win.isEmpty()){
                    System.out.println("Победа");
                }
                if (!defeat.isEmpty()){
                    System.out.println("Поражение");
                }
                break;
            case 3:
                String st = "";
                List<String> stage = words.stream()
                        .filter(word -> word.getMetka().equals("С"))
                        .map(Word::getBasic).collect(Collectors.toList());
                if (stage.get(0).equals("восьм")){
                    st = "1/8";
                }
                if (stage.get(0).equals("четверт")){
                    st = "1/4";
                }
                if (stage.get(0).equals("втор")){
                    st = "1/2";
                }
                if (stage.get(0).equals("финал")){
                    st = "final";
                }
                if (stage.get(0).equals("трет")){
                    st = "3place";
                }
                List<Teams> teams2 = dataDAO.getTeams(st);
                System.out.println("Список команд на стадии " + st + ": " + teams2);
                break;
            case 4:
                List<String> stage2 = words.stream()
                        .filter(word -> word.getMetka().equals("С"))
                        .map(Word::getBasic).collect(Collectors.toList());
                List<String> wordPlace = words.stream()
                        .filter(word -> word.getMetka().equals("С"))
                        .map(Word::getWord).collect(Collectors.toList());
                String team2 = "";
                if (stage2.get(0).equals("перв")){
                    team2 = "Франция";
                }
                if (stage2.get(0).equals("втор")){
                    team2 = "Хорватия";
                }
                if (stage2.get(0).equals("трет")){
                    team2 = "Бельгия";
                }
                if (stage2.get(0).equals("четверт")){
                    team2 = "Англия";
                }
                System.out.println(wordPlace.get(0) + " место заняла команда - " + team2);
                break;
            case 5:
                List<String> team = words.stream()
                        .filter(word -> word.getMetka().equals("К"))
                        .map(Word::getBasic).collect(Collectors.toList());
                List<String> teamName = words.stream()
                        .filter(word -> word.getMetka().equals("К"))
                        .map(Word::getWord).collect(Collectors.toList());
                int countMatches = dataDAO.getCountMatches(team.get(0));
                System.out.println("Команда " + teamName.get(0) + " сыграла " + countMatches + " матчей");
                break;
            case 0:
                System.out.println("Система не поняла ваш вопрос. Пожалуйста повторите его.");
                break;
        }
    }
}
