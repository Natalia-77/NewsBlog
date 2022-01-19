package program;

import createTable.CreateTable;

public class Main {
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        createTable.connection();
        createTable.createTableCategory();
        createTable.createTableNews();
    }
}
