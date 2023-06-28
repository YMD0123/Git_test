package com.sample;

import java.util.ArrayList;
import java.util.Scanner;

// Shift を 2 回押して 'どこでも検索' ダイアログを開き、`show whitespaces` と入力して
// Enter キーを押します。これでコードに空白文字が表示されます。
public class Main {

    final static int  tableMax = 5;
    final static int  menuMax  = 9;

    static int orderNum;

    static Table per0,per1,per2,per3,per4;
    static Table[] tables = {per0,per1,per2,per3,per4};
    static Menu  D1,D2,D3,M1,M2,M3,B1,B2,B3;
    static Menu[]  menus  = {D1,D2,D3,M1,M2,M3,B1,B2,B3};
    static ArrayList orders;

    public static void main(String[] args) {

        //Order test = new Order(0,0,0,0,"test");
        //System.out.println(test.toString());

        int flg;
        flg = Cafestart();

        if(flg == 0){
            System.out.println("正常終了");
        }
    }

    public static int Cafestart(){
        init();

        while(true){
            System.out.println("入室状況:0 注文:1 終了:2 その他:3");
            Scanner scan = new Scanner(System.in);
            int ope1 = scan.nextInt();


            if(ope1 == 1){
                //dispM();
                System.out.println("何番卓へ?(0-4)");
                int numT = scan.nextInt();
                if(numT < 0 || numT >= tableMax){
                    System.out.println("存在しない卓です");
                    continue;
                }

                System.out.println("メニュー番号を入力して下さい");
                int numM = scan.nextInt();
                int rnum = checkM(numM);

                if(rnum == -1){
                    System.out.println("存在しないメニュー番号です");
                    continue;
                }
                //System.out.println(rnum);

                System.out.println("個数を入力して下さい");
                int quant = scan.nextInt();
                //反映処理(オーダーの追加,テーブル状況の追加,)
                int amount = menus[rnum].getPrice() * quant;
                reflectM(numT,numM,quant,amount);
                Order o = (Order) orders.get(orderNum);
                //伝票の出力
                //System.out.println(o.toString());
                orderNum++;
            }
            else if(ope1 == 2){
                break;
            }
            else if(ope1 == 3){

                System.out.println("売上金額　:　" + sumSalesAmount());
            }
        }

        return 0;
    }

    public static int sumSalesAmount(){
        int sum = 0;
        for (int i = 0; i < orderNum;i++) {
            Order o = (Order) orders.get(i);
            sum += o.getTotal_amount();
        }

        return sum;
    }

    //-------------------メニューの追加----------------------------------------
    public static void reflectM(int numT,int numM,int quant/*個数*/,int amount){
        //オーダーの追加
        orders.add(new Order(numT,numM,quant,amount,"test"));
        //テーブル状況の追加
        tables[numT].total_amount += amount;

    }

    public static int checkM(int num){
        int i;
        for (i = 0;i < menuMax;i++) {
            if(num == menus[i].getMenu()){
                break;
            }
            else if(i+1 == menuMax){
                i = -1;
                break;
            }
        }

        return i;
    }

    public static void dispM(){
        System.out.println(" 番号 : 値段 : 商品名");
        for (Menu menu : menus) {
            System.out.printf(" %4d : %4d : %s \n",menu.getMenu(),menu.getPrice(),menu.getName());
        }
    }
//------------処理------------------------

    public static void init(){

        tables[0] = new Table(0,0);
        tables[1] = new Table(1,0);
        tables[2] = new Table(2,0);
        tables[3] = new Table(3,0);
        tables[4] = new Table(4,0);

        menus[0] = new Menu(1001,100,1,"drink1");
        menus[1] = new Menu(1002,200,1,"drink2");
        menus[2] = new Menu(1003,300,1,"drink3");

        menus[3] = new Menu(2001,100,2,"muffin1");
        menus[4] = new Menu(2002,200,2,"muffin2");
        menus[5] = new Menu(2003,300,2,"muffin3");

        menus[6] = new Menu(3001,100,3,"breed1");
        menus[7] = new Menu(3002,200,3,"breed2");
        menus[8] = new Menu(3003,300,3,"breed3");
        orderNum = 0;
        orders = new ArrayList();
    }

}