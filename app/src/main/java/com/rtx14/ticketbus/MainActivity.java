package com.rtx14.ticketbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.rtx14.ticketbus.SpinnerView.SpinnerBerangkatKota;
import com.rtx14.ticketbus.SpinnerView.SpinnerOrangAnak;
import com.rtx14.ticketbus.SpinnerView.SpinnerOrangDewasa;
import com.rtx14.ticketbus.SpinnerView.SpinnerUsedBis;
import com.rtx14.ticketbus.SpinnerView.SpinnerUsedKelas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnLogout, btnBooking, btnLihatTiket;
    EditText edNamaPenumpang;
    Spinner spUsedBis, spUsedKelas, spBerangkatKota, spTibaKota, spOrangDewasa, spOrangAnak;
    SharedPreferences sharedPreferences;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinnerUsedBis();
        SpinnerUsedKelas();
        SpinnerBerangkatKota();
        SpinnerTibaKota();
        SpinnerOrangDewasa();
        SpinnerOrangAnak();

        btnLogout = findViewById(R.id.btnLogout);
        btnBooking = findViewById(R.id.btnBooking);
        btnLihatTiket = findViewById(R.id.btnLihatTiket);

        edNamaPenumpang = findViewById(R.id.edNamaPenumpang);

        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

        mAuth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(MainActivity.this, "Logout Berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        btnLihatTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListTiket.class);
                startActivity(intent);
            }
        });

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private void SpinnerUsedBis()
    {
        spUsedBis = findViewById(R.id.spUsedBis);

        ArrayList<SpinnerUsedBis> list = new ArrayList<>();
        list.add(new SpinnerUsedBis("Bis Armada"));
        list.add(new SpinnerUsedBis("Bis Trans"));
        list.add(new SpinnerUsedBis("Bis Damri"));
        list.add(new SpinnerUsedBis("Bis Karya"));
        list.add(new SpinnerUsedBis("Bis Kurnia"));
        ArrayAdapter<SpinnerUsedBis> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUsedBis.setAdapter(adapter);
    }

    private void SpinnerUsedKelas()
    {
        spUsedKelas = findViewById(R.id.spUsedKelas);
        ArrayList<SpinnerUsedKelas> list = new ArrayList<>();
        list.add(new SpinnerUsedKelas("Ekonomi"));
        list.add(new SpinnerUsedKelas("Eksekutif"));
        list.add(new SpinnerUsedKelas("Bisnis"));
        list.add(new SpinnerUsedKelas("VIP"));
        ArrayAdapter<SpinnerUsedKelas> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUsedKelas.setAdapter(adapter);
    }

    private void SpinnerBerangkatKota()
    {
        spBerangkatKota = findViewById(R.id.spBerangkatKota);

        ArrayList<SpinnerBerangkatKota> list = new ArrayList<>();
        list.add(new SpinnerBerangkatKota("BDG"));
        list.add(new SpinnerBerangkatKota("JKT"));
        list.add(new SpinnerBerangkatKota("SBY"));
        list.add(new SpinnerBerangkatKota("SMG"));
        ArrayAdapter<SpinnerBerangkatKota> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBerangkatKota.setAdapter(adapter);
    }

    private void SpinnerTibaKota()
    {
        spTibaKota = findViewById(R.id.spTibaKota);

        ArrayList<SpinnerBerangkatKota> list = new ArrayList<>();
        list.add(new SpinnerBerangkatKota("BDG"));
        list.add(new SpinnerBerangkatKota("JKT"));
        list.add(new SpinnerBerangkatKota("SBY"));
        list.add(new SpinnerBerangkatKota("SMG"));
        ArrayAdapter<SpinnerBerangkatKota> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTibaKota.setAdapter(adapter);
    }

    private void SpinnerOrangDewasa()
    {
        spOrangDewasa = findViewById(R.id.spOrangDewasa);

        ArrayList<SpinnerOrangDewasa> list = new ArrayList<>();
        list.add(new SpinnerOrangDewasa(0));
        list.add(new SpinnerOrangDewasa(1));
        list.add(new SpinnerOrangDewasa(2));
        list.add(new SpinnerOrangDewasa(3));
        list.add(new SpinnerOrangDewasa(4));
        list.add(new SpinnerOrangDewasa(5));
        ArrayAdapter<SpinnerOrangDewasa> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOrangDewasa.setAdapter(adapter);
    }

    private void SpinnerOrangAnak()
    {
        spOrangAnak = findViewById(R.id.spOrangAnak);

        ArrayList<SpinnerOrangAnak> list = new ArrayList<>();
        list.add(new SpinnerOrangAnak(0));
        list.add(new SpinnerOrangAnak(1));
        list.add(new SpinnerOrangAnak(2));
        list.add(new SpinnerOrangAnak(3));
        list.add(new SpinnerOrangAnak(4));
        list.add(new SpinnerOrangAnak(5));
        ArrayAdapter<SpinnerOrangAnak> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOrangAnak.setAdapter(adapter);
    }

    private void saveData()
    {
        // Simpan Data menggunakan shared preference baik dari Edit Text maupun dari Spinner
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NamaPenumpang", edNamaPenumpang.getText().toString());
        editor.putString("UsedBis", spUsedBis.getSelectedItem().toString());
        editor.putString("UsedKelas", spUsedKelas.getSelectedItem().toString());
        editor.putString("BerangkatKota", spBerangkatKota.getSelectedItem().toString());
        editor.putString("TibaKota", spTibaKota.getSelectedItem().toString());
        editor.putString("OrangDewasa", spOrangDewasa.getSelectedItem().toString());
        editor.putString("OrangAnak", spOrangAnak.getSelectedItem().toString());
        editor.apply();

        Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
    }
}