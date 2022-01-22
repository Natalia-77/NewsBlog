package createTable;

import java.sql.*;

public class CreateTable {
    private final String url = "jdbc:postgresql://91.238.103.41:5432/javaproduct";
    private final String user = "javauser";
    private final String password = "referencestart123456";

    public Connection connection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    private final String createTableSQL = "CREATE TABLE categories " +
            "(ID INT PRIMARY KEY ," +
            " NAME VARCHAR(50))";

    private final String createTableNewsSQL = "CREATE TABLE news " +
            "(ID INT PRIMARY KEY," +
            " TITLE VARCHAR(50) NOT NULL, " +
            " DESCRIPTION TEXT NOT NULL, " +
            " AUTHOR VARCHAR(50) NOT NULL, " +
            " CATEGORY_ID INT NOT NULL REFERENCES categories(ID))";

    public void createTableCategory() {
        try (Connection connect = DriverManager.getConnection(url, user, password);
             Statement statement = connect.createStatement();) {
            if (!tableExist("categories")) {
                statement.execute(createTableSQL);
            } else {
                System.out.println("Table \"Categories\" already is exist!");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createTableNews() {
        try (Connection connect = DriverManager.getConnection(url, user, password);
             Statement statement = connect.createStatement();) {
            if (!tableExist("news")) {
                statement.execute(createTableNewsSQL);
            } else {
                System.out.println("Table  \"News\"  already is exist!");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean tableExist(String name) throws SQLException {
        boolean tExists = false;
        try (Connection connect = DriverManager.getConnection(url, user, password);) {
            try (ResultSet rs = connect.getMetaData().getTables(null, null, name, null)) {
                while (rs.next()) {
                    String tName = rs.getString(name);
                    if (tName != null && tName.equals(name)) {
                        tExists = true;
                        break;
                    }
                }
            }
        }

        return tExists;
    }


}
