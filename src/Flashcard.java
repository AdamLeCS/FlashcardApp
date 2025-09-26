// Class for every flashcard objects
public class Flashcard {
    String term;
    String definition;

    public Flashcard() {
        term = null;
        definition = null;
    }

    public Flashcard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getTerm() {
        return this.term;
    }

    public String getDefinition() {
        return this.definition;
    }
}
