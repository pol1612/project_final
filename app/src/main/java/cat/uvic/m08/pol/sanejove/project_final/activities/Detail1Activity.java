package cat.uvic.m08.pol.sanejove.project_final.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.math.NumberUtils;

import cat.uvic.m08.pol.sanejove.project_final.R;
import cat.uvic.m08.pol.sanejove.project_final.entities.PizzaOrder;
import cat.uvic.m08.pol.sanejove.project_final.singletone.AppSingleton;

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
    private static boolean hasDetail2SavedUpdatedDeletedCanceledBeforeFinish;
    private static boolean isEditModeOn;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        loadEdit1();
        if(pizzaOrderArrayListPosition!=-1){
            disable();
            loadEdit1Data();
        }
        isEditModeOn=false;
        hasDetail2SavedUpdatedDeletedCanceledBeforeFinish =false;
    }
    private void loadEdit1(){
        pizzaOrder= AppSingleton.getInstance().getPizzaOrder();
        pizzaOrderArrayList= AppSingleton.getInstance().getPizzaOrderArrayList();
        pizzaOrderArrayListPosition= AppSingleton.getInstance().getCurrentPosition();

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
            boolean allFormFieldsAreFilled=false;
            allFormFieldsAreFilled=(!txtEdClientName.getText().toString().equals("") && NumberUtils.isNumber(txtEdNumPizzaOrderPrice.getText().toString()) && !txtEdAddress.getText().toString().equals("") && !txtEdPasswordPizzaOrderCode.getText().toString().equals(""));
            //WHEN COMPARING STRINGS USE .equals, NOT '==
            if(allFormFieldsAreFilled) {
                pizzaOrder.setClientsName(txtEdClientName.getText().toString());
                pizzaOrder.setPrice(Float.parseFloat(txtEdNumPizzaOrderPrice.getText().toString()));
                pizzaOrder.setDeliveryCode(txtEdPasswordPizzaOrderCode.getText().toString());
                pizzaOrder.setDeliveryDate(datePickDeliveryDate.getDayOfMonth() + "/" + datePickDeliveryDate.getMonth() + "/" + datePickDeliveryDate.getYear());
                pizzaOrder.setDestination(txtEdAddress.getText().toString());
                pizzaOrder.setHasBeenDelivered(tgglBtnDeliveryStatus.isChecked());
                pizzaOrder.setSize(Integer.parseInt(spnPizzaOrderSize.getSelectedItem().toString()));
                Intent i = new Intent(Detail1Activity.this, Detail2Activity.class);
                startActivity(i);
            }else{
                builder=setOkNotificationDialogBuilder();
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        }
        if(id==R.id.deleteDetail1){
            AppSingleton.getInstance().deleteFromPizzaOrderArrayListItem();
            finish();
        }
        if(id==R.id.editDetail1){
            isEditModeOn=true;
            enable();
        }
        invalidateOptionsMenu();
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if(pizzaOrderArrayListPosition==-1){
            menu.findItem(R.id.deleteDetail1).setVisible(false);
            menu.findItem(R.id.editDetail1).setVisible(false);
        }else {
            if (isEditModeOn) {
                menu.findItem(R.id.deleteDetail1).setVisible(false);
                menu.findItem(R.id.editDetail1).setVisible(false);
            } else {
                menu.findItem(R.id.deleteDetail1).setVisible(true);
                menu.findItem(R.id.editDetail1).setVisible(true);
            }
        }
        return true;
    }
    private void enable() {
        txtEdClientName.setEnabled(true);
        txtEdNumPizzaOrderPrice.setEnabled(true);
        txtEdPasswordPizzaOrderCode.setEnabled(true);
        datePickDeliveryDate.setEnabled(true);
        txtEdAddress.setEnabled(true);
        tgglBtnDeliveryStatus.setEnabled(true);
        spnPizzaOrderSize.setEnabled(true);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (hasDetail2SavedUpdatedDeletedCanceledBeforeFinish) {
            finish();
        }

    }
    private void disable(){
        txtEdClientName.setEnabled(false);
        txtEdNumPizzaOrderPrice.setEnabled(false);
        txtEdPasswordPizzaOrderCode.setEnabled(false);
        datePickDeliveryDate.setEnabled(false);
        txtEdAddress.setEnabled(false);
        tgglBtnDeliveryStatus.setEnabled(false);
        spnPizzaOrderSize.setEnabled(false);
    }
    public static void setHasDetail2SavedUpdatedDeletedCanceledBeforeFinish(boolean hasDetail2SavedUpdatedDeletedButtonBeenPressed) {
        Detail1Activity.hasDetail2SavedUpdatedDeletedCanceledBeforeFinish = hasDetail2SavedUpdatedDeletedButtonBeenPressed;
    }

    public static boolean isIsEditModeOn() {
        return isEditModeOn;
    }

    public static void setIsEditModeOn(boolean isEditModeOn) {
        Detail1Activity.isEditModeOn = isEditModeOn;
    }
    private AlertDialog.Builder setOkNotificationDialogBuilder(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Detail1Activity.this);
        builder.setMessage("To proceed all fields must be correctly filled")
                .setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(),"you choose ok action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        return builder;
    }
}
