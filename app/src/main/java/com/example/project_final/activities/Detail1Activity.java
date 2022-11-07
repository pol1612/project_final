package com.example.project_final.activities;

import android.content.Intent;
import android.os.Bundle;
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

public class Detail1Activity extends AppCompatActivity {
    private TextView txtEdClientName;
    private TextView txtEdNumPizzaOrderPrice;
    private TextView txtEdPasswordPizzaOrderCode;
    private DatePicker datePickDeliveryDate;
    private TextView txtEdAddress;
    private ToggleButton tgglBtnDeliveryStatus;
    private Spinner spnPizzaOrderSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        loadEdit1();
        if(AppSingletone.getInstance().getCurrentPosition()!=-1){
            //get the data from the object using the list and the position
        }
    }
    private void loadEdit1(){
        txtEdClientName =findViewById(R.id.txtEdClientName);
        txtEdNumPizzaOrderPrice =findViewById(R.id.txtEdNumPizzaOrderPrice);
        txtEdPasswordPizzaOrderCode =findViewById(R.id.txtEdPasswordPizzaOrderCode);
        datePickDeliveryDate =findViewById(R.id.datePickDeliveryDate);
        txtEdAddress =findViewById(R.id.txtEdAddress);
        tgglBtnDeliveryStatus =findViewById(R.id.tgglBtnDeliveryStatus);
        spnPizzaOrderSize =findViewById(R.id.spnPizzaOrderSize);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, new String[]{"15", "20", "30"});
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPizzaOrderSize.setAdapter(aa);
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
            PizzaOrder pizzaOrder=AppSingletone.getInstance().getPizzaOrder();
            pizzaOrder.setClientsName(txtEdClientName.getText().toString());
            pizzaOrder.setPrice(Integer.parseInt(txtEdNumPizzaOrderPrice.getText().toString()));
            pizzaOrder.setDeliveryCode(txtEdPasswordPizzaOrderCode.getText().toString());
            pizzaOrder.setDeliveryDate(datePickDeliveryDate.getDayOfMonth()+"/"+datePickDeliveryDate.getMonth()+"/"+datePickDeliveryDate.getYear());
            pizzaOrder.setDestination(txtEdAddress.getText().toString());
            pizzaOrder.setHasBeenDelivered(tgglBtnDeliveryStatus.isChecked());
            pizzaOrder.setSize(Integer.parseInt(spnPizzaOrderSize.getSelectedItem().toString()));
            Intent i = new Intent(Detail1Activity.this, Detail2Activity.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.delete){
            //delete from list and finish task
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.delete).setVisible(!(AppSingletone.getInstance().getCurrentPosition()==-1));
        return true;
    }

}
