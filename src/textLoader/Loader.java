package textLoader;

import java.io.IOException;

public interface Loader<T> {
    T loadContent(String filePath) throws IOException;
}
