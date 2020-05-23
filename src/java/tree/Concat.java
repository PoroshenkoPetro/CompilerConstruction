package tree;

public class Concat {

    private final RegexTree left;
    private final RegexTree right;

    public Concat(RegexTree left, RegexTree right) {
        this.left = left;
        this.right = right;
    }

    public RegexTree getLeft() {
        return left;
    }

    public RegexTree getRight() {
        return right;
    }
}
