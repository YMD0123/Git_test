package com.sample;

public class Table {

    int total_amount;
    int[] total_type;
    static String situation;

    int num_table;
    int num_people;

    public Table(int table,int num_people){
        this.num_table     = table;
        this.num_people= num_people;
        total_amount = 0;
        total_type = new int[]{0, 0, 0};

    }
    public int getNum_table(){
        return this.num_table;
    }
    public int getNum_people(){
        return this.num_people;
    }
    public int getTotal_amount(){
        return total_amount;
    }

}
