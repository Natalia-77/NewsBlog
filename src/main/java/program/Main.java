package program;

import com.github.javafaker.Faker;
import createTable.CreateTable;
import deleteTable.DeleteData;
import insertToTable.InsertData;
import models.Categories;
import models.News;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        InsertData insert = new InsertData();
        DeleteData del = new DeleteData();
        del.deleteItem(108);

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
