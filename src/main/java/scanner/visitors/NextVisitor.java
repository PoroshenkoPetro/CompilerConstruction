package scanner.visitors;

import scanner.tree.*;

public class NextVisitor {

    public void visit(Concat node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        left.getNext().addAll(right.getFirst());
        if (node.getParent() != null) {
            if (right.isEmpty()) {
                left.getNext().addAll(node.getParent().getFirst());
            }
            right.getNext().addAll(node.getParent().getFirst());
        }
        left.calculateNext(this);
        right.calculateNext(this);
    }

    public void visit(Or node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        if (node.getParent() != null) {
            left.getNext().addAll(node.getParent().getFirst());
            right.getNext().addAll(node.getParent().getFirst());
        }
        left.calculateNext(this);
        right.calculateNext(this);
    }

    public void visit(Epsilon node) {
        if (node.getParent() != null) {
            node.getNext().addAll(node.getParent().getFirst());
        }
    }

    public void visit(Letter node) {
        if (node.getParent() != null) {
            node.getNext().addAll(node.getParent().getFirst());
        }
    }

    public void visit(Star node) {
        if (node.getParent() != null) {
            node.getNext().addAll(node.getParent().getFirst());
        }
        node.getNext().addAll(node.getR().getFirst());
        node.getR().calculateNext(this);
    }

}
