package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

public class Star extends RegexTree {

    private final RegexTree r;

    public Star(RegexTree r, RegexTree parent)
    {
        super(parent);
        this.r = r;
    }

    public RegexTree getR() {
        return r;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(r.hashCode());
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Star)) {
            return false;
        }
        Star star = (Star) obj;
        return star.getR().equals(this.r);
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
