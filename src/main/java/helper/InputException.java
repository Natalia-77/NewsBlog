package helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputException extends RuntimeException{
    //застосовується при введенні числа трохи по-іншому,ніж в класі StringValueException
    private String message;

    public InputException(String message) {

        this.message = message;
    }

}
