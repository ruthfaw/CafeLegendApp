package com.example.cafelegendapp;

public class Foodlist {

    String foodName;
    String foodRating;
    String foodSold;
    String foodPrice;
    int foodImage;
    String foodDesc;

    public Foodlist() {
    }

    public Foodlist(String foodName, String foodRating, String foodSold, String foodPrice, int foodImage, String foodDesc) {
        this.foodName = foodName;
        this.foodRating = foodRating;
        this.foodSold = foodSold;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.foodDesc = foodDesc;
    }

    //Getter

    public String getFoodName() {
        return foodName;
    }

    public String getFoodRating() {
        return foodRating;
    }

    public String getFoodSold() {
        return foodSold;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    //Setter


    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodRating(String foodRating) {
        this.foodRating = foodRating;
    }

    public void setFoodSold(String foodSold) {
        this.foodSold = foodSold;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }
}
