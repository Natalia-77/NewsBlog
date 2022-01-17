package createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    private final String url = "jdbc:postgresql://localhost:5432/javaproduct";
    private final String user = "javauser";
    private final String password = "referencestart123456";

    private static final String createTableSQL = "CREATE TABLE categories " +
            "(ID INT PRIMARY KEY ," +
            " NAME VARCHAR(50))";

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
}
