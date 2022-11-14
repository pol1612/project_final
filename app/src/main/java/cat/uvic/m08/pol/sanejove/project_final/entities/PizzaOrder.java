package cat.uvic.m08.pol.sanejove.project_final.entities;

import java.io.Serializable;

public class PizzaOrder implements Serializable {
    //detail1 attributes
    private float price;
    private String clientsName;
    private String deliveryCode;
    private String deliveryDate;
    private String destination;
    private boolean hasBeenDelivered;
    private int size;
    //detail2 attributes
    private boolean baseOfFlour;
    private boolean hasSpicyOil;
    private boolean hasTomatoSauce;
    private boolean hasMozzarella;
    private boolean hasGouda;
    private boolean hasRoquefort;
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
        hasRoquefort =false;
        hasSwissCheese=false;
        hasHam=false;
        hasBacon=false;
        hasMincedMeat=false;
        hasOregano=false;
        hasBlackPepper=false;
        clientsName ="";
        deliveryCode ="";
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

    public boolean isHasRoquefort() {
        return hasRoquefort;
    }

    public void setHasRoquefort(boolean hasRoquefort) {
        this.hasRoquefort = hasRoquefort;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public boolean isHasBeenDelivered() {
        return hasBeenDelivered;
    }

    public void setHasBeenDelivered(boolean hasBeenDelivered) {
        this.hasBeenDelivered = hasBeenDelivered;
    }
}
