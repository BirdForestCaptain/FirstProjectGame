package gameStates;

import exceptionHandler.ExceptionHandler;
import gameContext.GameContext;
import textLoader.Loader;
import textLoader.TextLoader;
import utils.RandomWord;

import java.util.List;

import static utils.ErrorMessages.ERROR_GETTING_MASKED_WORD;
import static utils.ErrorMessages.ERROR_GETTING_RANDOM_WORD;

public class StartState implements GameState {
    private final GameContext context;

    public StartState(GameContext context) {
        this.context = context;
    }

    @Override
    public void handle() {
        try {
            Loader loader = new TextLoader();
            List<String> words = (List<String>) loader.loadContent("C:\\Users\\YourName\\IdeaProjects\\Dictionary.txt");
            String randomWord = RandomWord.getRandomWord(words)
                    .orElseThrow(() -> new RuntimeException(ERROR_GETTING_RANDOM_WORD));
            context.setRandomWord(randomWord);

            List<Character> maskedWord = RandomWord.getMaskedRandomWord(randomWord)
                    .orElseThrow(() -> new IllegalArgumentException(ERROR_GETTING_MASKED_WORD));
            context.setMaskedWord(maskedWord);

            context.setState(new PlayingState(context));
            context.proceed();
        } catch (Exception e) {
            ExceptionHandler.handleExceptions(e);
        }
    }
}