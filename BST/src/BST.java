public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            add(root, e);
        }
    }

    private void add(Node n, E e) {
        if (e.equals(n.e)) {
            return;
        }
        else if (e.compareTo(n.e) < 0 && n.left == null) {
            n.left = new Node(e);
            size++;
        }
        else if (e.compareTo(n.e) > 0 && n.right == null) {
            n.right = new Node(e);
            size++;
        }

        if (e.compareTo(n.e) < 0) {
            add(n.left, e);
        } else {
            add(n.right, e);
        }
    }
}
