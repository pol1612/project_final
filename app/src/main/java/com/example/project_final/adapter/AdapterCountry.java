package com.example.project_final.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_final.R;
import com.example.project_final.entities.Country;
import com.example.project_final.entities.PizzaOrder;

import java.util.ArrayList;

public class AdapterCountry extends RecyclerView.Adapter<AdapterCountry.ViewHolder> {
    private ArrayList<PizzaOrder> pizzaOrders;

    public AdapterCountry(ArrayList<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_country, viewGroup, false);

            return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        /*Country item=this.countries.get(position);
        viewHolder.getName().setText(item.getName());
        viewHolder.getCity().setText(item.getCity()+"");
        viewHolder.getEurope().setChecked(item.isEurope());
    */}

    @Override
    public int getItemCount() {
        return this.pizzaOrders.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name;
        private final TextView city;
        private final CheckBox europe;

        public ViewHolder(View view){
            super(view);
            name=(TextView) view.findViewById(R.id.name);
            city=(TextView) view.findViewById(R.id.city);
            europe=(CheckBox) view.findViewById(R.id.europe);
        }

        public TextView getName() {
            return name;
        }

        public TextView getCity() {
            return city;
        }

        public CheckBox getEurope() {
            return europe;
        }
    }
    public static class EmptyViewHolder extends RecyclerView.ViewHolder{
        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
