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
        treeNodes.push(new Or(treeNodes.pop(), treeNodes.pop()));
        return this;
    }

    public TreeBuilder concat() {
        treeNodes.push(new Concat(treeNodes.pop(), treeNodes.pop()));
        return this;
    }

    public TreeBuilder star() {
        treeNodes.push(new Star(treeNodes.pop()));
        return this;
    }

    public RegexTree build() {
        return treeNodes.pop();
    }

}
