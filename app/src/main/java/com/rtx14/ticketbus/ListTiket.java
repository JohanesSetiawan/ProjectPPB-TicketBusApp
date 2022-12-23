package com.rtx14.ticketbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rtx14.ticketbus.Adapter.TestingAdapter;

import java.util.ArrayList;

public class ListTiket extends AppCompatActivity {

    ArrayList<ItemList> mExampleList;
    TextView textViewListTiket;
    private RecyclerView recyclerViewListTiket;
    private RecyclerView.LayoutManager layoutManagerListTiket;
    Button btnBooking, btnLihatTiket;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tiket);

        loadData();
        buildRecyclerView();

        textViewListTiket = findViewById(R.id.textViewListTiket);
        btnBooking = findViewById(R.id.btnBooking);
        btnLihatTiket = findViewById(R.id.btnLihatTiket);

        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListTiket.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnLihatTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListTiket.this, LihatTiket.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadData()
    {
        mExampleList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

        if (sharedPreferences.contains("NamaPenumpang"))
        {
            String NamaPenumpang = sharedPreferences.getString("NamaPenumpang", "");
            String BerangkatKota = sharedPreferences.getString("BerangkatKota", "");
            String TibaKota = sharedPreferences.getString("TibaKota", "");
            mExampleList.add(new ItemList(NamaPenumpang, BerangkatKota, TibaKota));
        }
    }

    private void buildRecyclerView()
    {
        recyclerViewListTiket = findViewById(R.id.recyclerViewListTiket);
        recyclerViewListTiket.setHasFixedSize(true);
        layoutManagerListTiket = new LinearLayoutManager(this);
        TestingAdapter adapter = new TestingAdapter(mExampleList);

        recyclerViewListTiket.setLayoutManager(layoutManagerListTiket);
        recyclerViewListTiket.setAdapter(adapter);

    }


}