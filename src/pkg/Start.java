package pkg;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Start {
    public Path filename = Paths.get("brain.lang");
    public static void main(String[] args) throws IOException {
        LogicHandler logic = new LogicHandler();
        logic.start_Logic();
    }
}
