package gameContext;

import gameStates.GameState;
import gameStates.HangmanStates;
import inputHandler.InputHandler;
import lombok.Getter;
import lombok.Setter;
import renderer.ConsoleRenderer;
import renderer.Renderer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Constants.UNDERLINE;
import static utils.Constants.USED_LETTERS_TEMPLATE;

@Getter
@Setter
public class GameContext {
    private GameState currentState;
    private String randomWord;
    private List<Character> maskedWord;
    private Set<String> correctGuessesSet = new HashSet<>();
    private Set<String> incorrectGuessesSet = new HashSet<>();
    private int incorrectGuessCount = 0;
    private final int MAX_INCORRECT_GUESSES = 6;

    private final Renderer<String, List<Character>> renderer = new ConsoleRenderer();
    private final InputHandler inputHandler = new InputHandler();
    private final Renderer<String, List<Character>> consoleRenderer = new ConsoleRenderer();

    public void setState(GameState state) {
        this.currentState = state;
    }

    public void proceed() {
        currentState.handle();
    }

    public boolean isAlreadyGuessed(String letter) {
        return correctGuessesSet.contains(letter) || incorrectGuessesSet.contains(letter);
    }

    public void handleGuess(String guessedLetter) {
        if (randomWord.contains(guessedLetter)) {
            correctGuessesSet.add(guessedLetter);
            updateMaskedWord(guessedLetter);
        } else {
            incorrectGuessesSet.add(guessedLetter);
            incorrectGuessCount++;
        }
    }

    private void updateMaskedWord(String guessedLetter) {
        char guessedLetterChar = guessedLetter.charAt(0);
        for (int i = 0; i < maskedWord.size(); i++) {
            if (guessedLetterChar == randomWord.charAt(i)) {
                maskedWord.set(i, guessedLetterChar);
            }
        }
    }

    public boolean isGameOver() {
        return incorrectGuessCount >= MAX_INCORRECT_GUESSES || !maskedWord.contains(UNDERLINE);
    }

    public boolean isWon() {
        return !maskedWord.contains(UNDERLINE);
    }

    public void render() {
        String stateToRender = HangmanStates.fromIncorrectGuessCount(incorrectGuessCount).getAscii();
        renderer.render(stateToRender, maskedWord);
        System.out.println(USED_LETTERS_TEMPLATE + incorrectGuessesSet.toString());
    }

}