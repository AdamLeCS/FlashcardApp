
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FlashcardSet {
    ArrayList<Flashcard> flashcards;
    Path filePath;
    String name;

    FlashcardSet(String setName) {
        flashcards = new ArrayList<>();
        try {
            Path path = Paths.get("./Flashcard_Sets/" + setName + ".txt");
            this.filePath = path;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1");
        }
        this.name = setName;
        
        this.fill();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Flashcard> getFlashcards() {
        return this.flashcards;
    }

    private void fill() {
        try (Scanner reader = new Scanner(this.filePath)) {
            while (reader.hasNextLine()) {
            String nextLine = reader.nextLine();
            String[] termAndDef = nextLine.split(",");
            flashcards.add(new Flashcard(termAndDef[0], termAndDef[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}