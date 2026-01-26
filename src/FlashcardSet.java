
import java.nio.file.Path;
import java.util.ArrayList;

public class FlashcardSet {
    ArrayList<Flashcard> flashcards;
    Path filePath;
    String name;

    FlashcardSet(String setName, Path file) {
        flashcards = new ArrayList<>();
        filePath = file;
        name = setName;
        
        
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Flashcard> getFlashcards() {
        return this.flashcards;
    }
}