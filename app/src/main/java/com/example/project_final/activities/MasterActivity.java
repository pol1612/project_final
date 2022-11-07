package com.example.project_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_final.R;
import com.example.project_final.adapter.PizzaOrderAdapter;
import com.example.project_final.entities.PizzaOrder;
import com.example.project_final.interfaces.ItemClickListener;
import com.example.project_final.singletone.AppSingletone;

public class MasterActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        this.recyclerView = findViewById(R.id.recycleView);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        PizzaOrderAdapter pizzaOrderAdapter=new PizzaOrderAdapter(AppSingletone.getInstance().getPizzaOrderArrayList(), this);
        AppSingletone.getInstance().setPizzaOrderAdapter(pizzaOrderAdapter);
        recyclerView.setAdapter(pizzaOrderAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_master, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.add){
            AppSingletone.getInstance().setCurrentPosition(-1);
            AppSingletone.getInstance().setPizzaOrder(new PizzaOrder());
            Intent i = new Intent(MasterActivity.this, Detail1Activity.class);
            startActivity(i);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(int position) {

    }
}