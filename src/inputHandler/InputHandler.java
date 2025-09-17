package inputHandler;

import exceptionHandler.EmptyInputException;
import exceptionHandler.LengthException;
import exceptionHandler.NonEnglishCharacterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static utils.Constants.INPUT_LETTER;
import static utils.ErrorMessages.*;

public class InputHandler {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Optional<String> getLetter() throws IOException {
        System.out.println(INPUT_LETTER);
        String inputLetter = reader.readLine().trim().toUpperCase();
        if (!isEnglishLetter(inputLetter)) {
            throw new NonEnglishCharacterException(INVALID_LETTER);
        }
        if (isEmptyLetter(inputLetter)) {
            throw new EmptyInputException(EMPTY_LETTER);
        }
        if (!isLengthCorrect(inputLetter)) {
            throw new LengthException(INVALID_LENGTH_LETTER);
        }
        return Optional.of(inputLetter);
    }

    private boolean isEnglishLetter(String letter) {
        return letter.matches("[a-zA-Z]+");
    }

    private boolean isEmptyLetter(String letter) {
        return letter == null || letter.isBlank();
    }

    private boolean isLengthCorrect(String letter)  {
        return letter.length()==1;
    }
}
