package com.rtx14.ticketbus.SpinnerView;

public class SpinnerOrangAnak {
    private Integer OrangAnak;

    public SpinnerOrangAnak(Integer orangAnak) {
        OrangAnak = orangAnak;
    }

    public Integer getOrangAnak() {
        return OrangAnak;
    }

    public void setOrangAnak(Integer orangAnak) {
        OrangAnak = orangAnak;
    }

    @Override
    public String toString() {
        return OrangAnak.toString();
    }
}
