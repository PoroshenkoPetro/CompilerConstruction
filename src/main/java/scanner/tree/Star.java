package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.visitors.EmptyVisitor;

public class Star extends RegexTree {

    private final RegexTree r;

    public Star(RegexTree r) {
        this.r = r;
    }

    public RegexTree getR() {
        return r;
    }

    @Override
    public void calculateEmpty(EmptyVisitor visitor) {
        setEmpty(visitor.visit(this));
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

}
