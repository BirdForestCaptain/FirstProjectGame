package gameStates;

public enum HangmanStates {
    EMPTY("""
              _____
              |  |
              |
              |
              |
             _|___
            """),

    HEAD("""
              _____
              |  |
              |  O
              |
              |
             _|___
            """),

    BODY("""
              _____
              |  |
              |  O
              |  |
              |
             _|___
            """),

    LEFT_ARM("""
              _____
              |  |
              |  O
              | /|
              |
             _|___
            """),

    RIGHT_ARM("""
              _____
              |  |
              |  O
              | /|\\
              |
             _|___
            """),

    LEFT_LEG("""
              _____
              |  |
              |  O
              | /|\\
              | /
             _|___
            """),

    RIGHT_LEG("""
              _____
              |  |
              |  O
              | /|\\
              | / \\
             _|___
            """);
    private final String ascii;
    HangmanStates(String ascii) {
        this.ascii = ascii;
    }
    public String getAscii() {
        return ascii;
    }
    public static HangmanStates fromIncorrectGuessCount(int count) {
        if (count < 0 || count >= values().length) {
            return RIGHT_LEG; // последний элемент
        }
        return values()[count];
    }
}
