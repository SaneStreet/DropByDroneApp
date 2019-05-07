package com.sanestreet.dronebyapp.model;

public class NovoSample {

    private String info;
    private int barcode;

    NovoSample(){}

    NovoSample(String info, int bar){
        this.barcode = bar;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setBarcode(int bar) {
        this.barcode = bar;
    }
}
