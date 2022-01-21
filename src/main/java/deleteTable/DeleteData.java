package deleteTable;

import models.News;
import java.sql.*;
import java.util.List;

public class DeleteData {
    private static final String url = "jdbc:postgresql://91.238.103.41:5432/javaproduct";
    private static final String user = "javauser";
    private static final String password = "referencestart123456";

    private final String deleteDataSQL = " DELETE FROM news WHERE id = ?;";
    private static final String selectItemSQL = " SELECT id,title,description,author,category_id FROM news WHERE id = ?;";

    public static boolean isExistItem(int num) {

        boolean existItem = false;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(selectItemSQL);) {

            preparedStatement.setInt(1, num);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String title = res.getString("title");
                String description = res.getString("description");
                String author = res.getString("author");
                int categoryId = res.getInt("category_id");
                System.out.println("Result :" + id + " Title: " + title + " Author: " + author + " Category id : " + categoryId);

                existItem = true;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return existItem;
    }

    public void deleteItem(int idDel) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteDataSQL);) {
            if(isExistItem(idDel)){
                preparedStatement.setInt(1, idDel);
                int resultDelete = preparedStatement.executeUpdate();
                System.out.println("You deleted " + resultDelete + " rows");
            }
            else{
                System.out.println("Doesn't exist item with "+ idDel + " id");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
