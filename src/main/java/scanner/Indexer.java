package scanner;


public class Indexer {

    public static final Indexer instance = new Indexer();

    private int index = 0;

    private Indexer() {

    }

    public int nextIndex() {
        return index++;
    }

}
