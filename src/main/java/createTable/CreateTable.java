package createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private final String url = "jdbc:postgresql://91.238.103.41:5432/javaproduct";
    private final String user = "javauser";
    private final String password = "referencestart123456";

    public Connection connection (){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,user,password);
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
    private  final String createTableSQL = "CREATE TABLE categories " +
            "(ID INT PRIMARY KEY ," +
            " NAME VARCHAR(50))";

    private  final String createTableNewsSQL =  "CREATE TABLE news " +
            "(ID INT PRIMARY KEY," +
            " TITLE VARCHAR(50) NOT NULL, " +
            " DESCRIPTION TEXT NOT NULL, " +
            " AUTHOR VARCHAR(50) NOT NULL, " +
            " CATEGORY_ID INT NOT NULL REFERENCES categories(ID))";

    public void createTableCategory(){
        try(Connection connect = DriverManager.getConnection(url,user,password);
            Statement statement = connect.createStatement();)
        {
            statement.execute(createTableSQL);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void createTableNews(){
        try(Connection connect = DriverManager.getConnection(url,user,password);
            Statement statement = connect.createStatement();)
        {
            statement.execute(createTableNewsSQL);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


}
