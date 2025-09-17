package gameStates;

import exceptionHandler.ExceptionHandler;
import gameContext.GameContext;
import inputHandler.InputHandler;

import static utils.Constants.ALREADY_GUESSED_LETTER_TEMPLATE;
import static utils.ErrorMessages.ERROR_GETTING_GUESSED_LETTER;

public class PlayingState implements GameState {

    private final GameContext context;

    public PlayingState(GameContext context) {
        this.context = context;
    }

    @Override
    public void handle() {
        InputHandler inputHandler = context.getInputHandler();
        while (!context.isGameOver()) {
            context.render();
            try {
                String guessedLetter = inputHandler.getLetter().orElseThrow(() -> new IllegalArgumentException(ERROR_GETTING_GUESSED_LETTER));
                if (context.isAlreadyGuessed(guessedLetter)) {
                    System.out.printf(ALREADY_GUESSED_LETTER_TEMPLATE, guessedLetter);
                    continue;
                }
                context.handleGuess(guessedLetter);

            } catch (Exception e) {
                ExceptionHandler.handleExceptions(e);
            }
        }
        context.render();
        transitionToEndState();
    }

    private void transitionToEndState() {
        context.setState(context.isWon() ? new WonState(context) : new LostState(context));
        context.proceed();
    }
}
