package com.vg.lp.services;

public class ServiceTypeQuestion {
    public int getTypeQuestion(String number){
        if (number.equals("11000000010") ||
                number.equals("01000000010") ||
                number.equals("01000000000")) {
            return 1;
        }
        if (number.equals("00110100000") ||
                number.equals("00101100000")){
            return 2;
        }
        if (number.equals("00100110000") ||
                number.equals("00000110000")){
            return 3;
        }
        if (number.equals("00100001000") ||
                number.equals("00000001000")){
            return 4;
        }
        if (number.equals("00000000110")){
            return 5;
        }
        return 0;
    }
}
