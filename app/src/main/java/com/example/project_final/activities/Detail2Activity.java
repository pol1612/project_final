package com.example.project_final.activities;

import android.os.Bundle;
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

    private ArrayList<PizzaOrder> pizzaOrderArrayList;
    private PizzaOrder pizzaOrder;
    private int pizzaOrderArrayListPosition;

    private RadioButton rdBtnFlour;
    private RadioButton rdBtnYeast;
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
        if(pizzaOrderArrayListPosition!=-1){
            loadDetail2Data();
        }
    }

    private void loadDetail2Data() {
        rdBtnFlour.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isBaseOfFlour());
        rdBtnYeast.setChecked(!pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isBaseOfFlour());
        chBxSpicyOil.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasSpicyOil());
        chBxTomatoSauce.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasTomatoSauce());
        chBxHam.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasHam());
        chBxBacon.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasBacon());
        chBxMozzarella.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasMozzarella());
        chBxMincedMeat.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasMincedMeat());
        chBxGouda.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasGouda());
        chBxOregano.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasOregano());
        chBxRoquefort.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasRoquefort());
        chBxBlackPepper.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasBlackPepper());
        chBxSwissCheese.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasSwissCheese());
    }

    private void loadDetail2(){
        pizzaOrderArrayList=AppSingletone.getInstance().getPizzaOrderArrayList();
        pizzaOrder=AppSingletone.getInstance().getPizzaOrder();
        pizzaOrderArrayListPosition=AppSingletone.getInstance().getCurrentPosition();

        rdBtnFlour=findViewById(R.id.rdBtnFlour);
        rdBtnYeast=findViewById(R.id.rdBtnYeast);
        chBxSpicyOil=findViewById(R.id.chBxSpicyOil);
        chBxTomatoSauce=findViewById(R.id.chBxTomatoSauce);
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
            pizzaOrder.setBaseOfFlour(rdBtnFlour.isChecked());
            pizzaOrder.setHasSpicyOil(chBxSpicyOil.isChecked());
            pizzaOrder.setHasTomatoSauce(chBxTomatoSauce.isChecked());
            pizzaOrder.setHasHam(chBxHam.isChecked());
            pizzaOrder.setHasBacon(chBxBacon.isChecked());
            pizzaOrder.setHasMozzarella(chBxMozzarella.isChecked());
            pizzaOrder.setHasMincedMeat(chBxMincedMeat.isChecked());
            pizzaOrder.setHasGouda(chBxGouda.isChecked());
            pizzaOrder.setHasOregano(chBxOregano.isChecked());
            pizzaOrder.setHasRoquefort(chBxRoquefort.isChecked());
            pizzaOrder.setHasBlackPepper(chBxBlackPepper.isChecked());
            pizzaOrder.setHasSwissCheese(chBxSwissCheese.isChecked());
            pizzaOrderArrayList.add(pizzaOrder);
            Detail1Activity.setHasDetail2SavedUpdatedDeletedBeforeFinish(true);
            finish();
            return true;
        }
        if(id==R.id.deleteDetail2){
            pizzaOrderArrayList.remove(pizzaOrderArrayListPosition);
            Detail1Activity.setHasDetail2SavedUpdatedDeletedBeforeFinish(true);
            finish();
            return true;
        }
        if(id==R.id.update){
            pizzaOrder.setBaseOfFlour(rdBtnFlour.isChecked());
            pizzaOrder.setHasSpicyOil(chBxSpicyOil.isChecked());
            pizzaOrder.setHasTomatoSauce(chBxTomatoSauce.isChecked());
            pizzaOrder.setHasHam(chBxHam.isChecked());
            pizzaOrder.setHasBacon(chBxBacon.isChecked());
            pizzaOrder.setHasMozzarella(chBxMozzarella.isChecked());
            pizzaOrder.setHasMincedMeat(chBxMincedMeat.isChecked());
            pizzaOrder.setHasGouda(chBxGouda.isChecked());
            pizzaOrder.setHasOregano(chBxOregano.isChecked());
            pizzaOrder.setHasRoquefort(chBxRoquefort.isChecked());
            pizzaOrder.setHasBlackPepper(chBxBlackPepper.isChecked());
            pizzaOrder.setHasSwissCheese(chBxSwissCheese.isChecked());
            pizzaOrderArrayList.set(pizzaOrderArrayListPosition,pizzaOrder);
            Detail1Activity.setHasDetail2SavedUpdatedDeletedBeforeFinish(true);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.deleteDetail2).setVisible(!(pizzaOrderArrayListPosition==-1));
        menu.findItem(R.id.update).setVisible(!(pizzaOrderArrayListPosition==-1));
        menu.findItem(R.id.save).setVisible((pizzaOrderArrayListPosition==-1));
        return true;
    }
}
