package scanner.tree;

import scanner.Indexer;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

import java.util.HashSet;
import java.util.Set;

public abstract class RegexTree {

    private boolean isEmpty;

    protected RegexTree parent;
    private Set<Integer> first = new HashSet<Integer>();
    private Set<Integer> next = new HashSet<Integer>();
    private Set<Integer> last = new HashSet<Integer>();

    public Set<Integer> getFirst() {
        return first;
    }

    public void setFirst(Set<Integer> first) {
        this.first = first;
    }

    public Set<Integer> getNext() {
        return next;
    }

    public Set<Integer> getLast() {
        return last;
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

    public void setParent(RegexTree parent) {
        this.parent = parent;
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
