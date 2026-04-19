package com.example.medicine_generator;

public class Data {

    String acidity,back,breath,chest,cold,desiase;

    public Data() {
    }

    public Data(String acidity, String back, String breath, String chest, String cold, String desiase) {
        this.acidity = acidity;
        this.back = back;
        this.breath = breath;
        this.chest = chest;
        this.cold = cold;
        this.desiase = desiase;
    }

    public String getAcidity() {
        return acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getBreath() {
        return breath;
    }

    public void setBreath(String breath) {
        this.breath = breath;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold;
    }

    public String getDesiase() {
        return desiase;
    }

    public void setDesiase(String desiase) {
        this.desiase = desiase;
    }
}
