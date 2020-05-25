package scanner.tree;

import scanner.Indexer;

public abstract class Leaf extends RegexTree {

    private final char content;
    private final int index;

    public Leaf(char content) {
        this.index = Indexer.instance.nextIndex();
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public char getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "(" + getContent() + " index " + getIndex() + ")";
    }

}
