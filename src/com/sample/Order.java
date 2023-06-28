package com.sample;

import java.util.List;

public class Order {
    private int num_table;
    private int num_menu;
    private int num_quantity;
    private int total_amount;
    private int num_order;
    private String staff_name;
    private static String situation;



    public Order(int table,int menu,int quantity,int total_amount,String sname){
        this.num_table  =   table;
        this.num_menu   =   menu;
        this.num_quantity=  quantity;
        this.staff_name =   sname;
        this.total_amount = total_amount;
        num_order++;
    }

    public int getNum_table(){
        return this.num_table;
    }
    public int getNum_menu(){return this.num_menu;}
    public int getNum_quantity(){return this.num_quantity;}
    public String getSname(){return this.staff_name;}
    public int getTotal_amount(){
        return total_amount;
    }

    @Override //注文内容の表示
    public String toString(){
        return  "伝番　:" + this.num_order   +
                "\n卓番　:" + this.num_table +
                "\n商番　:" + this.num_menu  +
                "\n個数　:" + this.num_quantity+
                "\n金額　:" + this.total_amount;
    }

}
