
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FlashcardSet {
    ArrayList<Flashcard> flashcards;
    long lastTimeOpened; // for "recently opened" sorting option
    Path filePath;

    FlashcardSet(String setName, Path file) {
        flashcards = new ArrayList<>();
        lastTimeOpened = System.currentTimeMillis(); 
        filePath = file;
        // Creates the file for this set in Flashcard_Sets folder
        try {
            Files.createFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}