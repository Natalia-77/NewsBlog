package program;

import createTable.CreateTable;
import deleteTable.DeleteData;
import insertToTable.InsertData;
import updateTable.UpdateData;
import java.util.*;

import static helper.CheckValidData.checkInputData;

public class Main {
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        InsertData insert = new InsertData();
        DeleteData del = new DeleteData();
        UpdateData up = new UpdateData();

        Scanner input = new Scanner(System.in);
        int operation;
        System.out.println("Add item to database --- 1");
        System.out.println("Edit item --- 2");
        System.out.println("Delete from database --- 3");
        System.out.println("Create table News --- 4");
        System.out.println("Create table Category --- 5");
        System.out.println("Enter number of operation :");
        while (!input.hasNext("q")) {
            operation = checkInputData();
            switch (operation) {
                case 1:
                    insert.insertNewsToTable();
                    break;
                case 2:
                    System.out.println("Enter id for edit:");
                    int idEdit = checkInputData();
                    up.updateTitleItem(idEdit);
                    break;
                case 3:
                    System.out.println("Enter id for delete:");
                    int idDelete = checkInputData();
                    del.deleteItem(idDelete);
                    break;
                case 4:
                    createTable.createTableNews();
                    break;
                case 5:
                    createTable.createTableCategory();
                    break;
                default:
                    System.out.println("Incorrect operation number...");
            }
        }
    }
}
