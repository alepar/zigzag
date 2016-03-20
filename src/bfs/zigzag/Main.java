package bfs.zigzag;

public class Main {

    public static void main(String[] args) {
	    final Node root = createTree();
        final Visitor printer = n -> System.out.print(n.getValue() + " ");

//        final Walker walker = new BfsWalker();
        final Walker walker = new ZigzagBfsWalker();
        walker.walk(root, printer);
    }

    private static Node createTree() {
        return new Node(1,
            new Node(2,
                new Node(4),
                new Node(5,
                    new Node(12),
                    new Node(11)
                )
            ),
            new Node(3,
                new Node(6,
                    new Node(10)
                ),
                new Node(7),
                new Node(8,
                    new Node(9)
                )
            )
        );
    }
}
