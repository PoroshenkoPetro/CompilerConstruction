package scanner.tree;

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

}
