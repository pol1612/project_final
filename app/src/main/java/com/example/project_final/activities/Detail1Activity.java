package com.example.project_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_final.R;
import com.example.project_final.entities.PizzaOrder;
import com.example.project_final.singletone.AppSingletone;

import java.util.ArrayList;
import java.util.Arrays;

public class Detail1Activity extends AppCompatActivity {
    private ArrayList<PizzaOrder> pizzaOrderArrayList;
    private PizzaOrder pizzaOrder;
    private int pizzaOrderArrayListPosition;
    private TextView txtEdClientName;
    private TextView txtEdNumPizzaOrderPrice;
    private TextView txtEdPasswordPizzaOrderCode;
    private DatePicker datePickDeliveryDate;
    private TextView txtEdAddress;
    private ToggleButton tgglBtnDeliveryStatus;
    private Spinner spnPizzaOrderSize;
    private static boolean hasDetail2SavedUpdatedDeletedButtonBeenPressed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        loadEdit1();
        if(AppSingletone.getInstance().getCurrentPosition()!=-1){
            loadEdit1Data();
        }
        hasDetail2SavedUpdatedDeletedButtonBeenPressed=false;
    }
    private void loadEdit1(){
        pizzaOrder=AppSingletone.getInstance().getPizzaOrder();
        pizzaOrderArrayList=AppSingletone.getInstance().getPizzaOrderArrayList();
        pizzaOrderArrayListPosition=AppSingletone.getInstance().getCurrentPosition();

        txtEdClientName =findViewById(R.id.txtEdClientName);
        txtEdNumPizzaOrderPrice =findViewById(R.id.txtEdNumPizzaOrderPrice);

        txtEdPasswordPizzaOrderCode =findViewById(R.id.txtEdPasswordPizzaOrderCode);
        txtEdPasswordPizzaOrderCode.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        datePickDeliveryDate =findViewById(R.id.datePickDeliveryDate);
        txtEdAddress =findViewById(R.id.txtEdAddress);
        tgglBtnDeliveryStatus =findViewById(R.id.tgglBtnDeliveryStatus);
        spnPizzaOrderSize =findViewById(R.id.spnPizzaOrderSize);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, new String[]{"15", "20", "30"});

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnPizzaOrderSize.setAdapter(aa);
    }
    private void loadEdit1Data(){
        txtEdClientName.setText(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getClientsName());
        txtEdNumPizzaOrderPrice.setText(Float.toString(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getPrice()));

        txtEdPasswordPizzaOrderCode.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        txtEdPasswordPizzaOrderCode.setText( pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getDeliveryCode());

        int year= Integer.parseInt(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getDeliveryDate().split("/")[2]);
        int month=Integer.parseInt(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getDeliveryDate().split("/")[1]);
        int day=Integer.parseInt(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getDeliveryDate().split("/")[0]);
        datePickDeliveryDate.updateDate(year,month,day);
        txtEdAddress.setText(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getDestination());
        tgglBtnDeliveryStatus.setChecked(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).isHasBeenDelivered());
        int pos= Arrays.asList(new String[] {"15", "20", "30"}).indexOf(Integer.toString(pizzaOrderArrayList.get(pizzaOrderArrayListPosition).getSize()));
        spnPizzaOrderSize.setSelection(pos);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_detail1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.next){
            pizzaOrder.setClientsName(txtEdClientName.getText().toString());
            pizzaOrder.setPrice(Float.parseFloat(txtEdNumPizzaOrderPrice.getText().toString()));
            pizzaOrder.setDeliveryCode(txtEdPasswordPizzaOrderCode.getText().toString());
            pizzaOrder.setDeliveryDate(datePickDeliveryDate.getDayOfMonth()+"/"+datePickDeliveryDate.getMonth()+"/"+datePickDeliveryDate.getYear());
            pizzaOrder.setDestination(txtEdAddress.getText().toString());
            pizzaOrder.setHasBeenDelivered(tgglBtnDeliveryStatus.isChecked());
            pizzaOrder.setSize(Integer.parseInt(spnPizzaOrderSize.getSelectedItem().toString()));
            Intent i = new Intent(Detail1Activity.this, Detail2Activity.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.deleteDetail1){
            pizzaOrderArrayList.remove(pizzaOrderArrayListPosition);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.deleteDetail1).setVisible(!(AppSingletone.getInstance().getCurrentPosition()==-1));
        return true;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(hasDetail2SavedUpdatedDeletedButtonBeenPressed){
            finish();
        }
    }

    public static void setHasDetail2SavedUpdatedDeletedBeforeFinish(boolean hasDetail2SavedUpdatedDeletedButtonBeenPressed) {
        Detail1Activity.hasDetail2SavedUpdatedDeletedButtonBeenPressed = hasDetail2SavedUpdatedDeletedButtonBeenPressed;
    }
}
