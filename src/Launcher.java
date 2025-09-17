import gameContext.GameContext;
import gameStates.MenuState;

public class Launcher {
    public static void main(String[] args) {
        GameContext game = new GameContext();
        game.setState(new MenuState(game));
        game.proceed();
    }
}
