package com.example.project_final.singletone;

import com.example.project_final.activities.MasterActivity;
import com.example.project_final.adapter.PizzaOrderAdapter;
import com.example.project_final.entities.PizzaOrder;

import java.util.ArrayList;

public class AppSingletone {



    private ArrayList<PizzaOrder> pizzaOrderArrayList;
    private int currentPosition;
    private PizzaOrder pizzaOrder;
    private PizzaOrderAdapter pizzaOrderAdapter;

    private static class SingletonInstance {
        private static AppSingletone INSTANCE = new AppSingletone();
    }

    public static AppSingletone getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private AppSingletone() {
        //Constructor Singleton
        this.pizzaOrderArrayList = new ArrayList<>();
    }


    public ArrayList<PizzaOrder> getPizzaOrderArrayList() { return pizzaOrderArrayList; }

    public void setPizzaOrderArrayList(ArrayList<PizzaOrder> pizzaOrderArrayList) {
        this.pizzaOrderArrayList = pizzaOrderArrayList;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public PizzaOrderAdapter getPizzaOrderAdapter() {
        return pizzaOrderAdapter;
    }

    public void setPizzaOrderAdapter(PizzaOrderAdapter pizzaOrderAdapter) {
        this.pizzaOrderAdapter = pizzaOrderAdapter;
    }
}