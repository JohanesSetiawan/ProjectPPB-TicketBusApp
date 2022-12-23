package com.rtx14.ticketbus.SpinnerView;

public class SpinnerBerangkatKota {
    private String BerangkatKota;

    public SpinnerBerangkatKota(String berangkatKota) {
        BerangkatKota = berangkatKota;
    }

    public String getBerangkatKota() {
        return BerangkatKota;
    }

    public void setBerangkatKota(String berangkatKota) {
        BerangkatKota = berangkatKota;
    }

    @Override
    public String toString() {
        if (BerangkatKota == null) {
            return "Pilih Kota (Berangkat)";
        } else {
            return BerangkatKota;
        }
    }

    public int getNamaTiket() {
        return 0;
    }
}
