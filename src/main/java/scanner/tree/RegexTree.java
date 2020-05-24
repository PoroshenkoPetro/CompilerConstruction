package scanner.tree;

import scanner.Indexer;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

import java.util.Set;

public abstract class RegexTree {

    private boolean isEmpty;
    protected final RegexTree parent;

    private Set<Integer> first;

    protected RegexTree(RegexTree parent) {
        this.parent = parent;
    }

    public Set<Integer> getFirst() {
        return first;
    }

    public void setFirst(Set<Integer> first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    protected void setEmpty(boolean value) {
        this.isEmpty = value;
    }

    public RegexTree getParent() {
        return parent;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    public abstract void calculateEmpty(EmptyVisitor visitor);
    public abstract void calculateFirst(FirstVisitor visitor);
    public abstract void calculateNext(NextVisitor visitor);
    public abstract void calculateLast(LastVisitor visitor);
}
