package com.rtx14.ticketbus.SpinnerView;

public class SpinnerUsedKelas {
    private String UsedKelas;

    public SpinnerUsedKelas(String usedKelas) {
        UsedKelas = usedKelas;
    }

    public String getUsedKelas() {
        return UsedKelas;
    }

    public void setUsedKelas(String usedKelas) {
        UsedKelas = usedKelas;
    }

    @Override
    public String toString() {
        if (UsedKelas == null) {
            return "Pilih Kelas";
        } else {
            return UsedKelas;
        }
    }

}
