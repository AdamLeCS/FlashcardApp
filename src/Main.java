
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
   public static void main(String[] args) throws Exception {
        // Creates the folder for all flashcard set files
        Path path = Paths.get("./Flashcard_Sets");
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StartupFrame mainFrame = new StartupFrame();

    }
}
