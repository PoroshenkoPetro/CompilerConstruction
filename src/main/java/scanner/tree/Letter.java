package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.Indexer;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

import java.util.HashSet;
import java.util.Set;

public class Letter extends Leaf {

    public Letter(char letter) {
        super(letter);
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getIndex());
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Letter)) {
            return false;
        }
        Letter letter = (Letter) obj;
        return letter.getIndex() == this.getIndex();
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
        visitor.visit(this);
    }

    @Override
    public Set<Leaf> getLeaves() {
        HashSet<Leaf> leaves = new HashSet<>();
        leaves.add(this);
        return leaves;
    }
}
