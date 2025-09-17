package gameStates;

import gameContext.GameContext;

import static utils.Constants.GUESSED_WORD_TEMPLATE;
import static utils.Constants.LOSS_STATE;

public class LostState implements GameState {
    private final GameContext context;

    public LostState(GameContext context) {
        this.context = context;
    }
    @Override
    public void handle() {
        System.out.println(LOSS_STATE);
        System.out.printf(GUESSED_WORD_TEMPLATE, context.getRandomWord());
    }
}
