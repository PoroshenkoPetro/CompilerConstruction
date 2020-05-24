package scanner.tree;

import scanner.visitors.EmptyVisitor;

public class Letter extends RegexTree {

    private final char letter;

    public Letter(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public void calculateEmpty(EmptyVisitor visitor) {
        setEmpty(visitor.visit(this));
    }
}
