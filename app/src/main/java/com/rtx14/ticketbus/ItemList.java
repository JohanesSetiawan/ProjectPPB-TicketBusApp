package com.rtx14.ticketbus;

public class ItemList {
    private final String textViewNamaPenumpang2;
    private final String textViewBerangkatKota2;
    private final String textViewTibaKota2;

    public ItemList(String textViewNamaPenumpang2, String textViewBerangkatKota2, String textViewTibaKota2) {
        this.textViewNamaPenumpang2 = textViewNamaPenumpang2;
        this.textViewBerangkatKota2 = textViewBerangkatKota2;
        this.textViewTibaKota2 = textViewTibaKota2;
    }

    public String getTextViewNamaPenumpang2() {
        return textViewNamaPenumpang2;
    }

    public String getTextViewBerangkatKota2() {
        return textViewBerangkatKota2;
    }

    public String getTextViewTibaKota2() {
        return textViewTibaKota2;
    }
}
