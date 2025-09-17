package textLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static utils.ErrorMessages.FILE_NOT_FOUND_TEMPLATE;

public class TextLoader implements Loader<List<String>> {
    @Override
    public List<String> loadContent(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_TEMPLATE, filePath));
        }
        return Files.readAllLines(path);
    }
}
