package scanner.visitors;

import scanner.tree.*;

import java.util.Collection;

public class FirstVisitor {

    public void visit(Epsilon node) {
    }

    public void visit(Letter node) {
        node.getFirst().add(node.getIndex());
    }

    public void visit(Star node) {
        node.getR().calculateFirst(this);
        node.getFirst().addAll(node.getR().getFirst());
    }

    public void visit(Concat node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getLeft();
        left.calculateFirst(this);
        right.calculateFirst(this);
        node.getFirst().addAll(left.getFirst());
        if (left.isEmpty()) {
            node.getFirst().addAll(right.getFirst());
        }
    }

    public void visit(Or node) {
        RegexTree left = node.getLeft();
        RegexTree right = node.getLeft();
        left.calculateFirst(this);
        right.calculateFirst(this);
        node.getFirst().addAll(left.getFirst());
        node.getFirst().addAll(right.getFirst());
    }

}
