package com.rtx14.ticketbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.rtx14.ticketbus.R;

public class ListItem extends AppCompatActivity {

    TextView textViewNamaPenumpang2, textViewBerangkatKota2, textViewKe, textViewTibaKota2;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        textViewNamaPenumpang2 = findViewById(R.id.textViewNamaPenumpang2);
        textViewBerangkatKota2 = findViewById(R.id.textViewBerangkatKota2);
        textViewKe = findViewById(R.id.textViewKe);
        textViewTibaKota2 = findViewById(R.id.textViewTibaKota2);

        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

        getData();
    }

    private void getData() {
        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String namaPenumpang = sharedPreferences.getString("namaPenumpang", "");
        String berangkatKota = sharedPreferences.getString("berangkatKota", "");
        String tibaKota = sharedPreferences.getString("tibaKota", "");

        textViewNamaPenumpang2.setText(namaPenumpang);
        textViewBerangkatKota2.setText(berangkatKota);
        textViewKe.setText("Ke");
        textViewTibaKota2.setText(tibaKota);
    }
}