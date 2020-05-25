package scanner.visitors;

import scanner.tree.*;

public class NextVisitor {

    public void visit(Concat node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        left.getNext().addAll(right.getFirst());
        if (right.isEmpty()) {
            left.getNext().addAll(node.getNext());
        }
        right.getNext().addAll(node.getNext());
        left.calculateNext(this);
        right.calculateNext(this);
    }

    public void visit(Or node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getRight();
        left.getNext().addAll(node.getNext());
        right.getNext().addAll(node.getNext());
        left.calculateNext(this);
        right.calculateNext(this);
    }

    public void visit(Star node) {
        node.getR().getNext().addAll(node.getNext());
        node.getR().getNext().addAll(node.getR().getFirst());
        node.getR().calculateNext(this);
    }

}
