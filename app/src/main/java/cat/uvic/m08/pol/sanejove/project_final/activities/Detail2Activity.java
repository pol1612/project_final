package cat.uvic.m08.pol.sanejove.project_final.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cat.uvic.m08.pol.sanejove.project_final.R;
import cat.uvic.m08.pol.sanejove.project_final.entities.PizzaOrder;
import cat.uvic.m08.pol.sanejove.project_final.singletone.AppSingleton;

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

    private static boolean isEditModeOn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        loadDetail2();
        isEditModeOn=Detail1Activity.isIsEditModeOn();
        if(pizzaOrderArrayListPosition!=-1){
            loadDetail2Data();
            if(!isEditModeOn){
                disable();
            }
        }


    }

    private void disable() {
        rdBtnFlour.setEnabled(false);
        rdBtnYeast.setEnabled(false);
        chBxSpicyOil.setEnabled(false);
        chBxTomatoSauce.setEnabled(false);
        chBxHam.setEnabled(false);
        chBxBacon.setEnabled(false);
        chBxMozzarella.setEnabled(false);
        chBxMincedMeat.setEnabled(false);
        chBxGouda.setEnabled(false);
        chBxOregano.setEnabled(false);
        chBxRoquefort.setEnabled(false);
        chBxBlackPepper.setEnabled(false);
        chBxSwissCheese.setEnabled(false);
    }
    private void enable() {
        rdBtnFlour.setEnabled(true);
        rdBtnYeast.setEnabled(true);
        chBxSpicyOil.setEnabled(true);
        chBxTomatoSauce.setEnabled(true);
        chBxHam.setEnabled(true);
        chBxBacon.setEnabled(true);
        chBxMozzarella.setEnabled(true);
        chBxMincedMeat.setEnabled(true);
        chBxGouda.setEnabled(true);
        chBxOregano.setEnabled(true);
        chBxRoquefort.setEnabled(true);
        chBxBlackPepper.setEnabled(true);
        chBxSwissCheese.setEnabled(true);
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
        pizzaOrderArrayList= AppSingleton.getInstance().getPizzaOrderArrayList();
        pizzaOrder= AppSingleton.getInstance().getPizzaOrder();
        pizzaOrderArrayListPosition= AppSingleton.getInstance().getCurrentPosition();

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
            AppSingleton.getInstance().saveToPizzaOrderArrayListItem();
            Detail1Activity.setHasDetail2SavedUpdatedDeletedCanceledBeforeFinish(true);
            finish();
        }
        if(id==R.id.deleteDetail2){
            //pizzaOrderArrayList.remove(pizzaOrderArrayListPosition);
            AppSingleton.getInstance().deleteFromPizzaOrderArrayListItem();
            Detail1Activity.setHasDetail2SavedUpdatedDeletedCanceledBeforeFinish(true);
            finish();
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
            //pizzaOrderArrayList.set(pizzaOrderArrayListPosition,pizzaOrder);
            AppSingleton.getInstance().updatePizzaOrderArrayListItem();
            Detail1Activity.setHasDetail2SavedUpdatedDeletedCanceledBeforeFinish(true);
            finish();
        }
        if(id==R.id.cancel || id==R.id.home){
            Detail1Activity.setHasDetail2SavedUpdatedDeletedCanceledBeforeFinish(true);
            finish();
        }
        invalidateOptionsMenu();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if(pizzaOrderArrayListPosition==-1){
            menu.findItem(R.id.update).setVisible(false);
            menu.findItem(R.id.deleteDetail2).setVisible(false);
            menu.findItem(R.id.home).setVisible(false);
        }else {
            menu.findItem(R.id.save).setVisible(false);
            if(isEditModeOn){
                menu.findItem(R.id.deleteDetail2).setVisible(false);
                menu.findItem(R.id.update).setVisible(true);
                menu.findItem(R.id.cancel).setVisible(true);
                menu.findItem(R.id.home).setVisible(false);
            } else {
                menu.findItem(R.id.update).setVisible(false);
                menu.findItem(R.id.deleteDetail2).setVisible(true);
                menu.findItem(R.id.cancel).setVisible(false);
                menu.findItem(R.id.home).setVisible(true);
            }
        }
        return true;

    }
}
