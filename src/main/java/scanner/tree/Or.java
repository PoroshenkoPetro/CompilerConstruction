package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

public class Or extends RegexTree {

    private final RegexTree left;
    private final RegexTree right;

    public Or(RegexTree left, RegexTree right, RegexTree parent) {
        super(parent);
        this.left = left;
        this.right = right;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(left.hashCode());
        builder.append(right.hashCode());
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Or)) {
            return false;
        }
        Or concat = (Or)obj;
        return concat.getLeft().equals(this.getLeft()) && concat.getRight().equals(this.getRight());
    }

    public RegexTree getLeft() {
        return left;
    }

    public RegexTree getRight() {
        return right;
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
