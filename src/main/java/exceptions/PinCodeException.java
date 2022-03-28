package exceptions;

public class PinCodeException extends RuntimeException {
    public PinCodeException(String message) {
        super(message);
    }
}