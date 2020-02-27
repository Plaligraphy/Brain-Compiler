package pkg;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileHandler {
Start s = new Start();
    public String readFile() throws IOException {
        return Files.readString(s.filename, StandardCharsets.US_ASCII);
    }

}
