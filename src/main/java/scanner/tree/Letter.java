package scanner.tree;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import scanner.Indexer;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

public class Letter extends RegexTree {

    private final char letter;
    private final int index;

    public Letter(char letter, RegexTree parent) {
        super(parent);
        this.index = Indexer.instance.nextIndex();
        this.letter = letter;
    }

    public int getIndex() {
        return index;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(letter);
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Letter)) {
            return false;
        }
        Letter letter = (Letter) obj;
        return letter.getLetter() == this.getLetter();
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
