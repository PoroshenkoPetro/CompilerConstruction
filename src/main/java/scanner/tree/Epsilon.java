package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

public class Epsilon extends RegexTree {

    public Epsilon(RegexTree parent) {
        super(parent);
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(true);
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Epsilon;
    }

    @Override
    public void calculateEmpty(EmptyVisitor visitor) {
        setEmpty(visitor.visit(this));
    }

    @Override
    public void calculateFirst(FirstVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void calculateNext(NextVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void calculateLast(LastVisitor visitor) {
        visitor.visit(this);
    }

}
