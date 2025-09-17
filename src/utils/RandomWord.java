package utils;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static utils.Constants.UNDERLINE;
import static utils.ErrorMessages.LIST_IS_EMPTY;


@UtilityClass
public final class RandomWord {
    public static Optional<String> getRandomWord(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException(LIST_IS_EMPTY);
        }
        Random rand = new Random();
        return Optional.of(list.get(rand.nextInt(list.size())));
    }
    public static Optional<List<Character>> getMaskedRandomWord(String word) {
        List<Character> maskedWord = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            maskedWord.add(UNDERLINE);
        }
        if (maskedWord.isEmpty()) {
            throw new IllegalArgumentException(LIST_IS_EMPTY);
        }
        return Optional.of(maskedWord);
    }
}
