package tree;

public class RegexTree {

    public Epsilon epsilon() {
        return new Epsilon();
    }

    public Letter letter(char letter) {
        return new Letter(letter);
    }

    public Concat concat(RegexTree left, RegexTree right) {
        return new Concat(left, right);
    }

    public Or or(RegexTree left, RegexTree right) {
        return new Or(left, right);
    }

    public Star star(RegexTree star) {
        return new Star(star);
    }

}
