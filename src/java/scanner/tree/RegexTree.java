package scanner.tree;

import scanner.visitors.EmptyVisitor;

public abstract class RegexTree {

    private boolean isEmpty;

    public boolean isEmpty() {
        return isEmpty;
    }

    protected void setEmpty(boolean value) {
        this.isEmpty = value;
    }

    public abstract void calculateEmpty(EmptyVisitor visitor);
}
