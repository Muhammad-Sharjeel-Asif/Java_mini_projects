public class Binary_Search_Tree {
    public class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public Node insert(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insert(current.left, value);
        } else if (value > current.value) {
            current.right = insert(current.right, value);
        }

        return current;
    }

    public void printLeafNode(Node current) {
        if (current == null) {
            return;
        }
        
        if (current.left == null && current.right == null) {
            System.out.println(current.value);
        }
        
        printLeafNode(current.left);
        printLeafNode(current.right);
    }

    public void buildTree(int[] data) {
        if (data.length == 0) {
            return;
        }
        
        root = new Node(data[0]);
        for (int i = 1; i < data.length; i++) {
            insert(root, data[i]);
        }
    }

    public void inorderTraversal(Node current) {
        if (current != null) {
            inorderTraversal(current.left);
            System.out.print(current.value + " ");
            inorderTraversal(current.right);
        }
    }

    public static void main(String[] args) {
        Binary_Search_Tree BST = new Binary_Search_Tree();
        
        int[] data = {45, 76, 32, 40, 12, 0};
        
        BST.buildTree(data);
        
        System.out.println("In-order traversal of BST:");
        BST.inorderTraversal(BST.root);
        
        System.out.println("\n\nLeaf nodes:");
        BST.printLeafNode(BST.root);
    }
}