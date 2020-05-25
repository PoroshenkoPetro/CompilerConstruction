package scanner.visitors;

import scanner.tree.*;

public class EmptyVisitor {

    public boolean visit(Epsilon node) {
        return true;
    }

    public boolean visit(Letter node) {
        return false;
    }

    public boolean visit(Concat node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        left.calculateEmpty(this);
        right.calculateEmpty(this);
        return left.isEmpty() && right.isEmpty();
    }

    public boolean visit(Star node) {
        node.getR().calculateEmpty(this);
        return true;
    }

    public boolean visit(Or node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        left.calculateEmpty(this);
        right.calculateEmpty(this);
        return left.isEmpty() || right.isEmpty();
    }

}
