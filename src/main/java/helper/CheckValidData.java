package helper;

import java.util.Scanner;

public class CheckValidData {

    public static int checkInputData() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            System.out.println("Enter id for search in database: ");
            while(!scanner.hasNextInt()){
                System.out.println("This is not number!Try again.");
                scanner.next();
            }
            number= scanner.nextInt();

        } while (number <= 0);
        return number;
    }
}
