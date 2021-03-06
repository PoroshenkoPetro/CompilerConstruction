package scanner;

import scanner.tree.*;

import java.util.Stack;

public class TreeBuilder {

    private Stack<RegexTree> treeNodes;

    public TreeBuilder() {
        this.treeNodes = new Stack<>();
    }

    public TreeBuilder letter(char ch) {
        treeNodes.push(new Letter(ch));
        return this;
    }

    public TreeBuilder epsilon() {
        treeNodes.push(new Epsilon());
        return this;
    }

    public TreeBuilder or() {
        RegexTree left = treeNodes.pop();
        RegexTree right = treeNodes.pop();
        RegexTree root = new Or(right, left);
        treeNodes.push(root);
        return this;
    }

    public TreeBuilder concat() {
        RegexTree left = treeNodes.pop();
        RegexTree right = treeNodes.pop();
        RegexTree root = new Concat(right, left);
        treeNodes.push(root);
        return this;
    }

    public TreeBuilder star() {
        RegexTree r = treeNodes.pop();
        RegexTree root = new Star(r);
        treeNodes.push(root);
        return this;
    }

    public RegexTree build() {
        return treeNodes.pop();
    }

}
