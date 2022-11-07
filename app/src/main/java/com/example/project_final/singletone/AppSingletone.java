package com.example.project_final.singletone;

import com.example.project_final.entities.PizzaOrder;

import java.util.ArrayList;

public class AppSingletone {



    private ArrayList<PizzaOrder> pizzaOrderArrayList;
    private int currentPosition;
    private PizzaOrder pizzaOrder;

    private static class SingletonInstance {
        private static AppSingletone INSTANCE = new AppSingletone();
    }

    public static AppSingletone getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private AppSingletone() {
        //Constructor Singleton

        this.pizzaOrderArrayList = new ArrayList<>();
        //TODO: delete this
        PizzaOrder po=new PizzaOrder();
        po.setClientsName("pol");
        po.setDeliveryCode("snjkwde123");
        po.setHasBeenDelivered(true);
        pizzaOrderArrayList.add(po);
        pizzaOrderArrayList.add(po);
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
}