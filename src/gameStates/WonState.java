package gameStates;

import gameContext.GameContext;

import static utils.Constants.GUESSED_WORD_TEMPLATE;
import static utils.Constants.WON_STATE;

public class WonState implements GameState {

    private final GameContext context;

    public WonState(GameContext context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println(WON_STATE);
        System.out.printf(GUESSED_WORD_TEMPLATE, context.getRandomWord());
    }
}
