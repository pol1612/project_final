package com.example.project_final.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_final.R;
import com.example.project_final.entities.PizzaOrder;
import com.example.project_final.singletone.AppSingletone;

import java.util.ArrayList;

public class PizzaOrderAdapter extends RecyclerView.Adapter<PizzaOrderAdapter.ViewHolder> {
    private ArrayList<PizzaOrder> pizzaOrders;

    public PizzaOrderAdapter(ArrayList<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_pizza_order, viewGroup, false);

            return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PizzaOrder item=this.pizzaOrders.get(position);
        viewHolder.getClientsName().setText(item.getClientsName());
        viewHolder.getDeliveryCode().setText(item.getDeliveryCode()+"");
        viewHolder.getHasBeenDelivered().setChecked(item.isHasBeenDelivered());
    }

    @Override
    public int getItemCount() {
        return this.pizzaOrders.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView clientsName;
        private final TextView deliveryCode;
        private final CheckBox hasBeenDelivered;

        public ViewHolder(View view){
            super(view);
            clientsName=(TextView) view.findViewById(R.id.txtViwClientsName);
            deliveryCode =(TextView) view.findViewById(R.id.txtViwDeliveryCode);
            hasBeenDelivered =(CheckBox) view.findViewById(R.id.chkBoxHasBeenDelivered);
            /*view.setOnClickListener(
                    null
            );*/
        }

        public TextView getClientsName() {
            return clientsName;
        }

        public TextView getDeliveryCode() {
            return deliveryCode;
        }

        public CheckBox getHasBeenDelivered() {
            return hasBeenDelivered;
        }
    }
    public static class EmptyViewHolder extends RecyclerView.ViewHolder{
        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
