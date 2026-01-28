import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
public static void main(String[] args) throws Exception {
        // Creates the folder for all flashcard set files, if it doesn't already exist
        // Also, create file that has names of all flashcard set files, if it doesn't already exist
        try {
            Path pathToSetsFolder = Paths.get("./Flashcard_Sets");
            Files.createDirectories(pathToSetsFolder);
            Path allSetNamesFile = Paths.get("./Flashcard_Sets/allSetNames.csv");
            if (!Files.exists(allSetNamesFile)) {
            Files.createFile(allSetNamesFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StartupFrame mainFrame = new StartupFrame();

    }
}
