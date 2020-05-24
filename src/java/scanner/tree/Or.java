package scanner.tree;

import scanner.visitors.EmptyVisitor;

public class Or extends RegexTree {

    private final RegexTree left;
    private final RegexTree right;

    public Or(RegexTree left, RegexTree right) {
        this.left = left;
        this.right = right;
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

}
