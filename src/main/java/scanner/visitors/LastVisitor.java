package scanner.visitors;

import scanner.tree.*;

public class LastVisitor {

    public void visit(Concat node) {
        node.getRight().calculateLast(this);
        node.getLeft().calculateLast(this);
        node.getLast().addAll(node.getRight().getLast());
        if (node.getRight().isEmpty()) {
            node.getLast().addAll(node.getLeft().getLast());
        }
    }

    public void visit(Or node) {
        node.getLeft().calculateLast(this);
        node.getRight().calculateLast(this);
        node.getLast().addAll(node.getLeft().getLast());
        node.getLast().addAll(node.getRight().getLast());
    }

    public void visit(Letter node) {
        node.getLast().add(node.getIndex());
    }

    public void visit(Star node) {
        node.getR().calculateLast(this);
        node.getLast().addAll(node.getR().getLast());
    }

}
