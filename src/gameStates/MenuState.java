package gameStates;

import gameContext.GameContext;

import java.util.Scanner;

import static utils.Constants.EXIT;
import static utils.Constants.INVALID_CHOICE;

public class MenuState implements GameState {
    private final GameContext context;

    public MenuState(GameContext context) {
        this.context = context;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("""
                
                Добро пожаловать!
                ************* Игра HangMan *************
                Выберите один из вариантов:
                1 - Начать новую игру
                0 - Выйти из приложения
                Введите 0 или 1:
                """);
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "0" -> {
                System.out.println(EXIT);
                System.exit(0);
            }
            case "1" -> {
                context.setState(new StartState(context));
                context.proceed();
            }
            default -> {
                System.out.println(INVALID_CHOICE);
                context.setState(new MenuState(context));
                context.proceed();
            }
        }
    }
}
