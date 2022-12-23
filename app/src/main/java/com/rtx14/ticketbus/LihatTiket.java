package com.rtx14.ticketbus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rtx14.ticketbus.R;

import org.w3c.dom.Text;

public class LihatTiket extends AppCompatActivity {

    TextView textViewNamaPenumpang, textViewBis, textViewKelas, textViewBerangkatKota, textViewTibaKota, textViewPenumpangDewasa, textViewPenumpangAnak;
    Button btnBookingTiket;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_tiket);

        loadData();

        btnBookingTiket = findViewById(R.id.btnBookingTiket);

        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

        btnBookingTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LihatTiket.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void loadData()
    {
        TextView textViewNamaPenumpang = findViewById(R.id.textViewNamaPenumpang);
        TextView textViewBis = findViewById(R.id.textViewBis);
        TextView textViewKelas = findViewById(R.id.textViewKelas);
        TextView textViewBerangkatKota = findViewById(R.id.textViewBerangkatKota);
        TextView textViewTibaKota = findViewById(R.id.textViewTibaKota);
        TextView textViewPenumpangDewasa = findViewById(R.id.textViewPenumpangDewasa);
        TextView textViewPenumpangAnak = findViewById(R.id.textViewPenumpangAnak);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String NamaPenumpang = sharedPreferences.getString("NamaPenumpang", "");
        String Bis = sharedPreferences.getString("UsedBis", "");
        String Kelas = sharedPreferences.getString("UsedKelas", "");
        String BerangkatKota = sharedPreferences.getString("BerangkatKota", "");
        String TibaKota = sharedPreferences.getString("TibaKota", "");
        String PenumpangDewasa = sharedPreferences.getString("OrangDewasa", "");
        String PenumpangAnak = sharedPreferences.getString("OrangAnak", "");

        textViewNamaPenumpang.setText("Nama Penumpang: " + NamaPenumpang);
        textViewBis.setText("Bis: " + Bis);
        textViewKelas.setText("Kelas: " + Kelas);
        textViewBerangkatKota.setText("Berangkat (Kota): " + BerangkatKota);
        textViewTibaKota.setText("Tiba (Kota): " + TibaKota);
        textViewPenumpangDewasa.setText("Penumpang (Dewasa): " + PenumpangDewasa);
        textViewPenumpangAnak.setText("Penumpang (Anak): " + PenumpangAnak);

    }
}