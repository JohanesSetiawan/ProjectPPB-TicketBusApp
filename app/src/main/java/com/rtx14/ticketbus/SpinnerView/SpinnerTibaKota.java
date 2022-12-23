package com.rtx14.ticketbus.SpinnerView;

public class SpinnerTibaKota {
    private String TibaKota;

    public SpinnerTibaKota(String tibaKota) {
        TibaKota = tibaKota;
    }

    public String getTibaKota() {
        return TibaKota;
    }

    public void setTibaKota(String tibaKota) {
        TibaKota = tibaKota;
    }

    @Override
    public String toString() {
        if (TibaKota == null) {
            return "Pilih Kota (Tiba)";
        } else {
            return TibaKota;
        }
    }
}
