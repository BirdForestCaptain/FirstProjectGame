package exceptionHandler;

import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;

@UtilityClass
public final class ExceptionHandler {
    public static void handleExceptions(Exception ex) {
        if (ex instanceof FileNotFoundException) {
            System.err.println(ex.getMessage());
            System.exit(1);
        } else
            System.err.println(ex.getMessage());
    }
}
