package helper;

import java.util.Scanner;
import static helper.StringValueException.*;

public class CheckValidData {

    public static int checkInputData() throws InputException {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        do {
            while (!scanner.hasNextInt()) {
                try {
                    scanner.next();
                    throw new InputException("This is not a number.Try again...");
                } catch (InputException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            number = scanner.nextInt();

        } while (number <= 0);

        return number;
    }

    public static String checkStrValid(){
       Scanner scanner = new Scanner(System.in);
        String str = " ";
        do{
            //System.out.println("Enter string: ");
            str= scanner.nextLine();
                try {
                    validateString(str);
                    validateNumbersString(str);

                } catch (StringValueException stringException) {
                    System.out.println("Error: " + stringException.getMessage());
                }

        }
        //while(!str.matches("[a-zA-Z]*"));
        while(!str.matches("^([a-zA-Z]+\\s*)+$"));

        return str;
    }
}
