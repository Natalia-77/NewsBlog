package program;

import com.github.javafaker.Faker;
import createTable.CreateTable;
import insertToTable.InsertData;
import models.Categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args)  {
        CreateTable createTable = new CreateTable();
        InsertData insert = new InsertData();
        //Faker javafaker =  Faker.instance(new Locale("uk-UA"));
       // Locale lo = new Locale("uk","UA");
       // System.out.println(lo);
        insert.insertFaker();
        //List<Integer> list = new ArrayList<Integer>();
        //list.add(1);
        //list.add(3);
        //list.add(5);
       // for (int i = 0;i<10;i++){
           // System.out.println(javafaker.random().nextInt(list.size()));
           // int vali = javafaker.random().nextInt(list.size());
            //System.out.println(list.get(vali) + "**");
       // }


//        createTable.connection();
//        if(insert.isExistTable()){
//            System.out.println("yes");
//        }
//        else{
//            System.out.println("No");
//        }
        // insert.insertItemsCategory();
        //insert.insertListItems(Arrays.asList
                //(new Categories(5,"Вибори"),
               // new Categories(6,"Медицина"),
               // new Categories(7,"Світ")));
        //createTable.createTableCategory();
        //createTable.createTableNews();
    }
}
