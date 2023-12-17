package lab2.matrixHandler;

public class InsufficientElementsException extends Exception {
    InsufficientElementsException() {
        super("Insufficient number of elements");
    }
}
