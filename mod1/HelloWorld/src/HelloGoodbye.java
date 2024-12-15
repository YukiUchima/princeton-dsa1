import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public static void main(String[] args) {
        String name1 = args[0];
        String name2 = args[1];
        StdOut.printf("Hello %s and %s.\n", name1, name2);
        StdOut.printf("Goodbye %s and %s.", name2, name1);
    }
}
