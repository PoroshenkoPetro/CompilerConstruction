package scanner.visitors;

import scanner.tree.*;

public class NextVisitor {

    public void visit(Concat node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        left.getNext().addAll(right.getFirst());
        if (right.isEmpty()) {
            left.getNext().addAll(node.getParent().getFirst());
        }
        right.getNext().addAll(node.getParent().getFirst());
        left.calculateNext(this);
        right.calculateNext(this);
    }

    public void visit(Or node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        left.getNext().addAll(node.getParent().getFirst());
        right.getNext().addAll(node.getParent().getFirst());
        left.calculateNext(this);
        right.calculateNext(this);
    }

    public void visit(Epsilon node) {
        node.getNext().addAll(node.getParent().getFirst());
    }

    public void visit(Letter node) {
        node.getNext().addAll(node.getParent().getFirst());
    }

    public void visit(Star node) {
        node.getNext().addAll(node.getParent().getFirst());
        node.getNext().addAll(node.getR().getFirst());
        node.getR().calculateNext(this);
    }

}
