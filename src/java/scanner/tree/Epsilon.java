package scanner.tree;

import scanner.visitors.EmptyVisitor;

public class Epsilon extends RegexTree {

    @Override
    public void calculateEmpty(EmptyVisitor visitor) {
        setEmpty(visitor.visit(this));
    }

}
