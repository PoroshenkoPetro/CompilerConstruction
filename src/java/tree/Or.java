package tree;

public class Or {

    private final RegexTree left;
    private final RegexTree right;

    public Or(RegexTree left, RegexTree right) {
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
