package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {
    public final static Character UNDERLINE = '_';
    public final static String ALREADY_GUESSED_LETTER_TEMPLATE = "Вы уже отгадали данную букву : %s ! Попробуйте другую \n";
    public final static String GUESSED_WORD = "Загаданное слово : ";
    public final static String GUESSED_WORD_TEMPLATE = "Загаданное слово было : %s ";
    public final static String USED_LETTERS_TEMPLATE = "Использованные буквы : ";
    public final static String WON_STATE = "Вы победили!";
    public final static String LOSS_STATE = "Вы проиграли";
    public final static String EXIT = "Выход из игры";
    public final static String INVALID_CHOICE = "Недопустимый выбор. Повторите попытку.";
    public final static String INPUT_LETTER = "Введите букву : ";

}
