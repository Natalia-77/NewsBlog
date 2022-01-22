package program;

import com.github.javafaker.Faker;
import createTable.CreateTable;
import deleteTable.DeleteData;
import helper.CheckValidData;
import insertToTable.InsertData;
import models.Categories;
import models.News;
import updateTable.UpdateData;

import java.util.*;

import static helper.CheckValidData.checkInputData;

public class Main {
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        InsertData insert = new InsertData();
        DeleteData del = new DeleteData();
        UpdateData up = new UpdateData();

        Scanner input  = new Scanner(System.in);
        int operation;
        System.out.println("Add item to database --- 1");
        System.out.println("Edit item --- 2");
        System.out.println("Delete from database --- 3");
        while (!input.hasNext("q")) {

            System.out.println("Enter number of operation :");
            operation= checkInputData();

            switch(operation){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Incorrect operation number...");
            }
        }

        // insert.insertNewsToTable();
        //up.updateItem(107);
       // del.deleteItem(108);

        String ss = CheckValidData.checkStrValid();
        System.out.println(ss);
//        int d = CheckValidData.checkInputData();
//        System.out.println("res: "+d);

        //Faker javafaker =  Faker.instance(new Locale("uk-UA"));
        // Locale lo = new Locale("uk","UA");
        // System.out.println(lo);
        // insert.insertFaker();
        //createTable.connection();
        // insert.insertItemsCategory();
        //insert.insertListItems(Arrays.asList
        //(new Categories(5,"Вибори"),
        // new Categories(6,"Медицина"),
        // new Categories(7,"Світ")));
        //createTable.createTableCategory();
        //createTable.createTableNews();
    }
}
