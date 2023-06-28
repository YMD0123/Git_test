package com.sample;

public class Menu {
    int menu;
    int price;
    int category;
    String name;

    public Menu(int n_menu,int n_price,int n_category,String n){
        menu  = n_menu;
        price = n_price;
        category = n_category;
        name = n;
    }

    public int getMenu(){
        return this.menu;
    }
    public int getPrice(){
        return this.price;
    }
    public int getCategory(){
        return category;
    }
    public String getName(){return name;};



}
