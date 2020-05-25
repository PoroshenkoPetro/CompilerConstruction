package scanner;

import scanner.tree.Leaf;
import scanner.tree.Letter;
import scanner.tree.RegexTree;
import scanner.visitors.EmptyVisitor;
import scanner.visitors.FirstVisitor;
import scanner.visitors.LastVisitor;
import scanner.visitors.NextVisitor;

public class Runner {

    public static void main(String[] args) {
        RegexTree tree = new TreeBuilder()
                .epsilon()
                .letter('b')
                .letter('a')
                .concat()
                .or()
                .letter('c')
                .letter('a')
                .letter('b')
                .or()
                .star()
                .concat()
                .concat()
                .build();
        System.out.println(tree);
        tree.calculateEmpty(new EmptyVisitor());
        tree.calculateFirst(new FirstVisitor());
        tree.calculateNext(new NextVisitor());
        tree.calculateLast(new LastVisitor());
        for (Leaf l :
                tree.getLeaves()) {
            System.out.println(l);
            l.getNext().forEach(System.out::println);
        }
        tree.getLast().forEach(System.out::println);
    }

}
