package com.example.project_final.entities;

import java.io.Serializable;

public class PizzaOrder implements Serializable {
    private int units;
    private int price;
    private String clientsName;
    private String delivaryCode;
    private String deliveryDate;
    private String destination;
    private boolean hasBeenDelivered;
    private int size;
    private boolean baseOfFlour;
    private boolean hasSpicyOil;
    private boolean hasTomatoSauce;
    private boolean hasMozzarella;
    private boolean hasGouda;
    private boolean hasRoqueforte;
    private boolean hasSwissCheese;
    private boolean hasHam;
    private boolean hasBacon;
    private boolean hasMincedMeat;
    private boolean hasOregano;
    private boolean hasBlackPepper;


    public PizzaOrder() {
        size=0;
        deliveryDate="";
        hasTomatoSauce=false;
        hasMozzarella=false;
        hasGouda=false;
        hasRoqueforte=false;
        hasSwissCheese=false;
        hasHam=false;
        hasBacon=false;
        hasMincedMeat=false;
        hasOregano=false;
        hasBlackPepper=false;
        clientsName ="";
        delivaryCode="";
        hasBeenDelivered=false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isBaseOfFlour() {
        return baseOfFlour;
    }

    public void setBaseOfFlour(boolean baseOfFlour) {
        this.baseOfFlour = baseOfFlour;
    }

    public boolean isHasSpicyOil() {
        return hasSpicyOil;
    }

    public void setHasSpicyOil(boolean hasSpicyOil) {
        this.hasSpicyOil = hasSpicyOil;
    }

    public boolean isHasTomatoSauce() {
        return hasTomatoSauce;
    }

    public void setHasTomatoSauce(boolean hasTomatoSauce) {
        this.hasTomatoSauce = hasTomatoSauce;
    }

    public boolean isHasMozzarella() {
        return hasMozzarella;
    }

    public void setHasMozzarella(boolean hasMozzarella) {
        this.hasMozzarella = hasMozzarella;
    }

    public boolean isHasGouda() {
        return hasGouda;
    }

    public void setHasGouda(boolean hasGouda) {
        this.hasGouda = hasGouda;
    }

    public boolean isHasRoqueforte() {
        return hasRoqueforte;
    }

    public void setHasRoqueforte(boolean hasRoqueforte) {
        this.hasRoqueforte = hasRoqueforte;
    }

    public boolean isHasSwissCheese() {
        return hasSwissCheese;
    }

    public void setHasSwissCheese(boolean hasSwissCheese) {
        this.hasSwissCheese = hasSwissCheese;
    }

    public boolean isHasHam() {
        return hasHam;
    }

    public void setHasHam(boolean hasHam) {
        this.hasHam = hasHam;
    }

    public boolean isHasBacon() {
        return hasBacon;
    }

    public void setHasBacon(boolean hasBacon) {
        this.hasBacon = hasBacon;
    }

    public boolean isHasMincedMeat() {
        return hasMincedMeat;
    }

    public void setHasMincedMeat(boolean hasMincedMeat) {
        this.hasMincedMeat = hasMincedMeat;
    }

    public boolean isHasOregano() {
        return hasOregano;
    }

    public void setHasOregano(boolean hasOregano) {
        this.hasOregano = hasOregano;
    }

    public boolean isHasBlackPepper() {
        return hasBlackPepper;
    }

    public void setHasBlackPepper(boolean hasBlackPepper) {
        this.hasBlackPepper = hasBlackPepper;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    public String getDelivaryCode() {
        return delivaryCode;
    }

    public void setDelivaryCode(String delivaryCode) {
        this.delivaryCode = delivaryCode;
    }

    public boolean isHasBeenDelivered() {
        return hasBeenDelivered;
    }

    public void setHasBeenDelivered(boolean hasBeenDelivered) {
        this.hasBeenDelivered = hasBeenDelivered;
    }
}
