package insertToTable;

import com.github.javafaker.Faker;
import models.Categories;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InsertData {
    private final String url = "jdbc:postgresql://91.238.103.41:5432/javaproduct";
    private final String user = "javauser";
    private final String password = "referencestart123456";

    private final String insertDataSQL = " INSERT INTO categories " +
            " (id,name) VALUES " + "(?,?);";
    private final String insertFakerDataSQL = " INSERT INTO news " +
            " (id,title,description,author,category_id ) VALUES " + "(?,?,?,?,?);";

    private final String selectDataSQL = "SELECT * FROM news";

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

    //перевірка,чи є дані у таблиці.
    public boolean isExistTable() {
        boolean exist = false;
        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(selectDataSQL);) {
            try (ResultSet result = preparedStatement.executeQuery();) {
                if (result.next()) {
                    exist = true;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return exist;
    }

    //список id таблиці Category в базі.Faker має генерити в таблиці news вторинні ключі з таблиці category
    // в межах цих значень id.Бо вони можуть іти не по порядку.
    public List<Integer> listCatId() {
        List<Integer> listId = new ArrayList<>();
        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(selectDataSQL);) {
            try (ResultSet result = preparedStatement.executeQuery();) {

                while (result.next()) {
                    int idItem = result.getInt("id");
                    listId.add(idItem);
                    //System.out.println(idItem+"-");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listId;
    }

    public void insertFaker() {
        Faker faker = Faker.instance(new Locale("uk"));
        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(insertFakerDataSQL);) {
            //перевірка,чи є дані у таблиці.Якщо даних немає-то додає їх.
            if (!isExistTable()) {
                //лічильник,значення якого буде показувати,через яку кількість ітерацій виконувати запит
                int count = 0, ids = 1, index = 0;
                List<Integer> listId = listCatId();
                for (int i = 0; i < 100; i++) {
                    index = faker.random().nextInt(listId.size());
                    preparedStatement.setInt(1, ids);
                    preparedStatement.setString(2, faker.country().name());
                    preparedStatement.setString(3, faker.chuckNorris().fact());
                    preparedStatement.setString(4, faker.buffy().celebrities());
                    preparedStatement.setInt(5, listId.get(index));
                    preparedStatement.addBatch();
                    count++;
                    ids++;
                    //буде виконано через кожні 20 ітерацій або ж
                    // коли буде досягнуто межу кількості елементів,які потрібно додати.
                    if (count % 20 == 0 || count == 100) {
                        preparedStatement.executeBatch();
                    }
                }
            } else {
                System.out.println("you cant add seeder!");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
