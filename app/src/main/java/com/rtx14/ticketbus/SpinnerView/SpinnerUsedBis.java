package com.rtx14.ticketbus.SpinnerView;

public class SpinnerUsedBis {
    private String UsedBis;

    public SpinnerUsedBis(String usedBis) {
        UsedBis = usedBis;
    }

    public String getUsedBis() {
        return UsedBis;
    }

    public void setUsedBis(String usedBis) {
        UsedBis = usedBis;
    }

    @Override
    public String toString() {
        if (UsedBis == null) {
            return "Pilih Bis";
        } else {
            return UsedBis;
        }
    }
}
