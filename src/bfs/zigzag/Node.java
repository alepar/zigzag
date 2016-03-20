package bfs.zigzag;

import java.util.Arrays;
import java.util.List;

public class Node {

    private final int value;
    private final List<Node> children;

    public Node(int value, Node... children) {
        this.value = value;
        this.children = Arrays.asList(children);
    }

    public int getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }
}
