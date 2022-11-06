package com.example.project_final;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.project_final.entities.Country;
import com.example.project_final.singletone.AppSingletone;

public class MainActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.listView);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, AppSingletone.getInstance().getList());

        //this.listView.setAdapter(adapter);

        /*ArrayAdapter<Country> adapter = new ArrayAdapter<>(MainActivity.this, AppSingletone.getInstance().getPizzaOrderArrayList(), android.R.layout.simple_list_item_1);

        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country item=(Country) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_LONG).show();
            }
        });*/
    }
}