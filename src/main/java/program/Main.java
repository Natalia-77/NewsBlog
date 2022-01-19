package program;

import createTable.CreateTable;
import insertToTable.InsertData;
import models.Categories;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {
        CreateTable createTable = new CreateTable();
        InsertData insert = new InsertData();
        createTable.connection();
        // insert.insertItemsCategory();
        insert.insertListItems(Arrays.asList
                (new Categories(5,"Вибори"),
                new Categories(6,"Медицина"),
                new Categories(7,"Світ")));
        //createTable.createTableCategory();
        //createTable.createTableNews();
    }
}
