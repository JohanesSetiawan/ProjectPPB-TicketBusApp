package com.rtx14.ticketbus.SpinnerView;

public class SpinnerOrangDewasa {
    private Integer OrangDewasa;

    public SpinnerOrangDewasa(Integer orangDewasa) {
        OrangDewasa = orangDewasa;
    }

    public Integer getOrangDewasa() {
        return OrangDewasa;
    }

    public void setOrangDewasa(Integer orangDewasa) {
        OrangDewasa = orangDewasa;
    }

    @Override
    public String toString() {
        return OrangDewasa.toString();
    }
}
