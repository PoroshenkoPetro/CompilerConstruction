package scanner.tree;

import scanner.Indexer;
import scanner.visitors.EmptyVisitor;

public abstract class RegexTree {

    private int index;
    private boolean isEmpty;

    public RegexTree() {
        index = Indexer.instance.nextIndex();
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    protected void setEmpty(boolean value) {
        this.isEmpty = value;
    }

    public abstract void calculateEmpty(EmptyVisitor visitor);
}
