package bfs.zigzag;

public class BfsWalker implements Walker {

    @Override
    public void walk(Node root, Visitor visitor) {
        for(int l=0; ; l++) {
            if(!walk(root, visitor, l, 0)) {
                break;
            }
        }
    }

    private boolean walk(Node node, Visitor visitor, int walkLevel, int curLevel) {
        if (walkLevel == curLevel) {
            visitor.visit(node);
            return true;
        }

        boolean found = false;
        for (Node child : node.getChildren()) {
            found |= walk(child, visitor, walkLevel, curLevel+1);
        }
        return found;
    }
}
