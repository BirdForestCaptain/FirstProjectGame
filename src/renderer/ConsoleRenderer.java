package renderer;

import java.util.List;

import static utils.Constants.GUESSED_WORD;

public class ConsoleRenderer implements Renderer<String,List<Character>> {
    @Override
    public void render(String content,List<Character> maskedWord) {
        System.out.println(content);
        System.out.println(GUESSED_WORD);
        printMaskedWord(maskedWord);
    }
    private void printMaskedWord(List<Character> maskedWord) {
        for (int i = 0; i < maskedWord.size(); i++) {
            System.out.print(maskedWord.get(i) + " ");
        }
        System.out.println();
    }
}