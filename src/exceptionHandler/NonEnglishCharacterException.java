package exceptionHandler;

public class NonEnglishCharacterException extends RuntimeException {
    public NonEnglishCharacterException(String message) {
        super(message);
    }
}
