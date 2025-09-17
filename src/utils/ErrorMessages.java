package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ErrorMessages {
    public static final String FILE_NOT_FOUND_TEMPLATE = "Файл %s по данному пути не найден. Работа программы завершена !";
    public static final String LIST_IS_EMPTY = "Список слов пуст.";
    public static final String INVALID_LETTER = "Ошибка: введите одну английскую букву.";
    public static final String EMPTY_LETTER = "Ошибка: буква не может быть пустой.";
    public static final String INVALID_LENGTH_LETTER = "Ошибка: введите только один символ/букву.";
    public static final String ERROR_GETTING_RANDOM_WORD = "Ошибка при выборе случайного слова.";
    public static final String ERROR_GETTING_MASKED_WORD = "Ошибка при формировании скрытого слова.";
    public static final String ERROR_GETTING_GUESSED_LETTER = "Ошибка при получении буквы";
}
