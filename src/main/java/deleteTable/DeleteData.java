package deleteTable;

import models.News;
import java.sql.*;
import java.util.List;

public class DeleteData {
    private final String url = "jdbc:postgresql://91.238.103.41:5432/javaproduct";
    private final String user = "javauser";
    private final String password = "referencestart123456";

    private final String deleteDataSQL = " DELETE FROM news WHERE id = ?;";
    private final String selectItemSQL = " SELECT id,title,description,author,category_id FROM news WHERE id = ?;";

    public boolean isExistItem() {
        boolean existItem = false;
        News news = new News();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(selectItemSQL);) {

            preparedStatement.setInt(1, 10550);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String title = res.getString("title");
                String description = res.getString("description");
                String author = res.getString("author");
                int categoryId = res.getInt("category_id");
                System.out.println("Result :" + id + " Title: " + title + " Author: " + author + "Category id : " + categoryId);
                news.setId(id);
                news.setTitle(title);
                news.setDescription(description);
                news.setAuthor(author);
                news.setCategoryId(categoryId);
                System.out.println("Return : " +news.getTitle());
                existItem = true;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return existItem;
    }

    public void deleteItem() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteDataSQL);) {

            preparedStatement.setInt(1, 106);
            int resultDelete = preparedStatement.executeUpdate();
            System.out.println("You deleted " + resultDelete + " rows");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
