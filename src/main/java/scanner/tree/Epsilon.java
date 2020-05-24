package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.visitors.EmptyVisitor;

public class Epsilon extends RegexTree {

    @Override
    public void calculateEmpty(EmptyVisitor visitor) {
        setEmpty(visitor.visit(this));
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

}
