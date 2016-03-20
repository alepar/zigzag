package bfs.zigzag;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

public class ZigzagBfsWalker implements Walker {

    @Override
    public void walk(Node root, Visitor visitor) {
        Direction dir = Direction.FWD;
        for(int l=0; ; l++) {
            if(!walk(root, visitor, l, 0, dir)) {
                break;
            }
            dir = dir.inverse();
        }
    }

    private boolean walk(Node node, Visitor visitor, int walkLevel, int curLevel, Direction dir) {
        if (walkLevel == curLevel) {
            visitor.visit(node);
            return true;
        }

        boolean found = false;
        for (Node child : dir.iterateOver(node.getChildren())) {
            found |= walk(child, visitor, walkLevel, curLevel+1, dir);
        }
        return found;
    }

    private enum Direction {
        FWD(nodes -> () -> nodes.iterator()),
        REV(nodes -> () -> new ReverseIterator(nodes));

        private final Function<List<Node>, Iterable<Node>> iterableFunction;

        private static final int sum = FWD.ordinal() + REV.ordinal();

        Direction(Function<List<Node>, Iterable<Node>> iterableFunction) {
            this.iterableFunction = iterableFunction;
        }

        public Direction inverse() {
            return Direction.values()[sum - ordinal()];
        }

        public Iterable<Node> iterateOver(List<Node> nodes) {
            return iterableFunction.apply(nodes);
        }

        private static class ReverseIterator implements Iterator<Node> {
            private final ListIterator<Node> delegate;

            public ReverseIterator(List<Node> list) {
                this.delegate = list.listIterator(list.size());
            }

            @Override
            public boolean hasNext() {
                return delegate.hasPrevious();
            }

            @Override
            public Node next() {
                return delegate.previous();
            }
        }
    }

}
