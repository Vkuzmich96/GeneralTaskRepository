package by.epam.bean;

public class Word {
    private PartOfTextKind kind;
    private String word;

    public Word(String word, PartOfTextKind kind) {
        this.word = word;
        this.kind = kind;
    }

    public String getWord() {
        return word;
    }

    public PartOfTextKind getKind() {
        return kind;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
