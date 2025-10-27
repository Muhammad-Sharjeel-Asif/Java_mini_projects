public class Binary_Search_Tree {
    public class Node {
        int rootNode;
        Node left, right;

        public Node(int value) {
            this.rootNode = value;
            this.left = null;
            this.right = null;
        }

        public Node insert(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.rootNode) {
                current.left = insert(current.left, value);
            } else if (value > current.rootNode) {
                current.right = insert(current.right, value);
            }
            return current;
        }

        public void printLeafNode(Node current) {
            if (current != null) {
                if (current.left == null && current.right == null) {
                    System.out.println(current.rootNode);
                }
                printLeafNode(current.left);
                printLeafNode(current.right);
            }
        }

    }

    int[] data = { 45, 76, 32, 40, 12, 0 };

    Node rootNode;

    public void arrangeTree() {
        rootNode = new Node(data[0]);
        for (int i = 1; i < data.length; i++) {
            rootNode.insert(rootNode, data[i]);
        }
    }

    public void printLeafNode() {
        if (rootNode != null) {
            rootNode.printLeafNode(rootNode);
        }
    }

    public static void main(String[] args) {
        Binary_Search_Tree BST = new Binary_Search_Tree();
        BST.arrangeTree();

        BST.printLeafNode();
    }
}