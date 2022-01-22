package helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringValueException extends RuntimeException {

    private String message;

    public StringValueException(String message) {

        this.message = message;
    }

    //Не повинна строчка починатись з пробіла чи бути порожньою
    public static void validateString(String value) {

        if (value.startsWith(" ") || value.equals(null)) {
            throw new StringValueException("Empty string !Try again...");
        }
    }

    //Не повинно бути введене число
    public static void validateNumbersString(String value) {

        if (value.matches("^[0-9]+$")) {
            throw new StringValueException("You enter a number! Try again...");
        }
    }
}
