package updateTable;

import deleteTable.DeleteData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static deleteTable.DeleteData.isExistItem;


public class UpdateData {
    Scanner in = new Scanner(System.in);
    private final String url = "jdbc:postgresql://91.238.103.41:5432/javaproduct";
    private final String user = "javauser";
    private final String password = "referencestart123456";
    private final String updateTitle = " UPDATE news SET title = ? WHERE id = ?;";
    private final String updateAuthor = " UPDATE news SET author = ? WHERE id = ?;";

    //редагування заголовку новини
    public void updateTitleItem(int idUpdate) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateTitle);) {
            if (isExistItem(idUpdate)) {
                System.out.print("Enter new title: ");
                in.nextLine();
                String title = in.nextLine();
                preparedStatement.setString(1, title);
                preparedStatement.setInt(2, idUpdate);

                int resultUpdate = preparedStatement.executeUpdate();
                System.out.println("You edited " + resultUpdate + " rows");
            } else {
                System.out.println("Doesn't exist item with " + idUpdate + " id");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //редагування автора новини
    public void updateAuthorItem(int idUpdate) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateAuthor);) {
            if (isExistItem(idUpdate)) {
                System.out.print("Enter new author: ");
                in.nextLine();
                String author = in.nextLine();
                preparedStatement.setString(1, author);
                preparedStatement.setInt(2, idUpdate);

                int resultUpdate = preparedStatement.executeUpdate();
                System.out.println("You edited " + resultUpdate + " rows");
            } else {
                System.out.println("Doesn't exist item with " + idUpdate + " id");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
