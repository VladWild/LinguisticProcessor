package com.vg.lp.datalayer.data;

import lombok.ToString;

@ToString
public class Specifications {
    private String ChR;
    private String Od;
    private String Chislo;
    private String Rod;
    private String Padezh;

    public String getChR() {
        return ChR;
    }

    public void setChR(String chR) {
        ChR = chR;
    }

    public String getOd() {
        return Od;
    }

    public void setOd(String od) {
        Od = od;
    }

    public String getChislo() {
        return Chislo;
    }

    public void setChislo(String chislo) {
        Chislo = chislo;
    }

    public String getRod() {
        return Rod;
    }

    public void setRod(String rod) {
        Rod = rod;
    }

    public String getPadezh() {
        return Padezh;
    }

    public void setPadezh(String padezh) {
        Padezh = padezh;
    }
}
