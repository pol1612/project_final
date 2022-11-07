package com.example.project_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_final.R;
import com.example.project_final.entities.PizzaOrder;
import com.example.project_final.singletone.AppSingletone;

import java.util.ArrayList;


public class Detail2Activity extends AppCompatActivity {
    private RadioButton rdBtnFlour;
    private CheckBox chBxSpicyOil;
    private CheckBox chBxTomatoSauce;
    private CheckBox chBxHam;
    private CheckBox chBxBacon;
    private CheckBox chBxMozzarella;
    private CheckBox chBxMincedMeat;
    private CheckBox chBxGouda;
    private CheckBox chBxOregano;
    private CheckBox chBxRoquefort;
    private CheckBox chBxBlackPepper;
    private CheckBox chBxSwissCheese;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        loadDetail2();
    }
    private void loadDetail2(){
        rdBtnFlour=findViewById(R.id.rdBtnFlour);
        chBxHam=findViewById(R.id.chBxHam);
        chBxBacon=findViewById(R.id.chBxBacon);
        chBxMozzarella=findViewById(R.id.chBxMozzarella);
        chBxMincedMeat=findViewById(R.id.chBxMincedMeat);
        chBxGouda=findViewById(R.id.chBxGouda);
        chBxOregano=findViewById(R.id.chBxOregano);
        chBxRoquefort=findViewById(R.id.chBxRoquefort);
        chBxBlackPepper=findViewById(R.id.chBxBlackPepper);
        chBxSwissCheese=findViewById(R.id.chBxSwissCheese);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_detail2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.save){
            PizzaOrder pizzaOrder=AppSingletone.getInstance().getPizzaOrder();
            pizzaOrder.setBaseOfFlour(rdBtnFlour.isChecked());
            pizzaOrder.setHasHam(chBxHam.isChecked());
            pizzaOrder.setHasBacon(chBxBacon.isChecked());
            pizzaOrder.setHasMozzarella(chBxMozzarella.isChecked());
            pizzaOrder.setHasMincedMeat(chBxMincedMeat.isChecked());
            pizzaOrder.setHasGouda(chBxGouda.isChecked());
            pizzaOrder.setHasOregano(chBxOregano.isChecked());
            pizzaOrder.setHasRoquefort(chBxRoquefort.isChecked());
            pizzaOrder.setHasBlackPepper(chBxBlackPepper.isChecked());
            pizzaOrder.setHasSwissCheese(chBxSwissCheese.isChecked());
            AppSingletone.getInstance().getPizzaOrderArrayList().add(pizzaOrder);
            AppSingletone.getInstance().getPizzaOrderAdapter().notifyDataSetChanged();
            finish();
            return true;
        }
        if(id==R.id.deleteDetail2){
            //delete from list and finish task
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.deleteDetail2).setVisible(!(AppSingletone.getInstance().getCurrentPosition()==-1));
        menu.findItem(R.id.update).setVisible(!(AppSingletone.getInstance().getCurrentPosition()==-1));
        menu.findItem(R.id.save).setVisible((AppSingletone.getInstance().getCurrentPosition()==-1));
        return true;
    }
}
