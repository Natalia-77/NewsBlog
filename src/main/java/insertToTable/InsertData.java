package insertToTable;

import models.Categories;

import java.sql.*;
import java.util.List;

public class InsertData {
    private final String url = "jdbc:postgresql://91.238.103.41:5432/javaproduct";
    private final String user = "javauser";
    private final String password = "referencestart123456";

    private final String insertDataSQL = " INSERT INTO categories " +
            " (id,name) VALUES " + "(?,?);";

    //додавання одного елемента
    public void insertItemsCategory() {
        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Політика");
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //додавання в базу даних списком
    public void insertListItems(List<Categories> categoryList) {
        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(insertDataSQL);) {
            //лічильник,значення якого буде показувати,через яку кількість ітерацій виконувати запит
            int count = 0;
            for (Categories cat : categoryList) {
                preparedStatement.setInt(1, cat.getId());
                preparedStatement.setString(2, cat.getName());
                preparedStatement.addBatch();
                count++;
                //буде виконано через кожні 3 ітерацій або ж коли значення лічильника рівне з розміром списку
                if (count % 3 == 0 || count == categoryList.size()) {
                    preparedStatement.executeBatch();
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
