package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

import java.util.HashSet;
import java.util.Set;

public class Epsilon extends Leaf {

    public Epsilon() {
        super('0');
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getIndex());
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Epsilon)) {
            return false;
        }
        Epsilon epsilon = (Epsilon) obj;
        return epsilon.getIndex() == this.getIndex();
    }

    @Override
    public String toString() {
        return "epsilon";
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
    }

    @Override
    public void calculateLast(LastVisitor visitor) {
    }

    @Override
    public Set<Leaf> getLeaves() {
        Set<Leaf> set = new HashSet<>();
        set.add(this);
        return set;
    }

}
