
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FlashcardSet {
    ArrayList<Flashcard> flashcards;
    long lastTimeOpened; // for "recently opened" sorting option
    Path filePath;

    FlashcardSet(String setName) {
        flashcards = new ArrayList<>();
        lastTimeOpened = System.currentTimeMillis(); 
        filePath = Paths.get("./Flashcard_Sets/" + setName + ".txt");
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}