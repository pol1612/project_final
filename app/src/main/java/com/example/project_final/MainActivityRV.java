package com.example.project_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_final.adapter.AdapterCountry;
import com.example.project_final.singletone.AppSingletone;

public class MainActivityRV extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recycleView);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, AppSingletone.getInstance().getList());

        //this.listView.setAdapter(adapter);

        /*ArrayAdapter<Country> adapter = new ArrayAdapter<>(MainActivityRV.this, android.R.layout.simple_list_item_1,
                AppSingletone.getInstance().getContryList());

        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country item=(Country) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_LONG).show();
            }
        });*/

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterCountry adapterCountry=new AdapterCountry(AppSingletone.getInstance().getPizzaOrderArrayList());
        recyclerView.setAdapter(adapterCountry);

    }
}