package Seminar3;

public class WrongAmountOfDataException extends RuntimeException {
    WrongAmountOfDataException(String message) {
        super(message);
    }

    WrongAmountOfDataException() {
        super();
    }
}
