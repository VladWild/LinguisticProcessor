package com.vg.lp.utilities.groups;

import java.util.*;

public class GroupsWords {
    public List<List<List<String>>> keys = new ArrayList<>();

    public GroupsWords(){
        //1. Уточнение на себя
        keys.add(Arrays.asList(
                        Arrays.asList("РМ", "Р"),
                        Arrays.asList("РМ", "П", "СОБ", "Р")
        ));

        //2. Две команды
        keys.add(Arrays.asList(
                    Arrays.asList("КОМ", "К", "КСЗ", "К"),
                    Arrays.asList("К", "КСЗ", "К")
        ));

        //3. Уточнения
        keys.add(Arrays.asList(
                    Arrays.asList("УТ"),
                    Arrays.asList("УТ", "КОМ")
        ));

        //4. Положительный результат
        keys.add(Arrays.asList(
                    Arrays.asList("Р+"),
                    Arrays.asList("Р+", "ПОБ")
        ));

        //5. Отрицетельный результат
        keys.add(Arrays.asList(
                    Arrays.asList("Р-")
        ));

        //6. Уточнение стадии
        keys.add(Arrays.asList(
                    Arrays.asList("П", "М", "С"),
                    Arrays.asList("П", "С"),
                    Arrays.asList("П", "М", "П", "С", "МЕСТ"),
                    Arrays.asList("П", "С", "МЕСТ"),
                    Arrays.asList("МС", "С"),
                    Arrays.asList("П", "С")
        ));

        //7. Участие
        keys.add(Arrays.asList(
                    Arrays.asList("УЧ"),
                    Arrays.asList("УЧ", "П"),
                    Arrays.asList("УЧ", "П", "СТАД", "П")
        ));

        //8. Результат турнира
        keys.add(Arrays.asList(
                Arrays.asList("Р", "C"),
                Arrays.asList("Р", "С", "МЕСТ")
        ));

        //9. Количество матчей
        keys.add(Arrays.asList(
                Arrays.asList("КОЛ", "М")
        ));

        //10. Уточнение команды
        keys.add(Arrays.asList(
                Arrays.asList("Р", "К")
        ));

        //11. Уточнение прохода
        keys.add(Arrays.asList(
                Arrays.asList("РМ", "СТАД"),
                Arrays.asList("П", "УТ", "СТАД")
        ));
    }
}
