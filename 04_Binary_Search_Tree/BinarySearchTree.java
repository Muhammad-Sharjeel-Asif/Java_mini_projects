public class BinarySearchTree {
    class Node{
        int rootNode;
        Node rightNode, leftNode;

        Node(int value){
            this.rootNode = value;
            this.leftNode = null;
            this.rightNode = null;

        }
    }

    Node root;

    public Node insert(Node root, int value){
        if (root == null){
            return new Node(value);
        }
        if (value > root.rootNode){
            return root.leftNode = insert(root, value);
        }
        if (value < root.rootNode){
            return root.rightNode = insert(root, value);
        }
        return root;
    }

    public int printLeafNode(Node root){
        if(root == null){
            return 0;
        }
        if(root.leftNode == null && root.rightNode == null){
            return 1;
        }
        return printLeafNode(root.leftNode) + printLeafNode(root.rightNode);
    }

    
    public static void main(String[] args) {
        
        int[] data = {46, 37, 79, 31, 0, -17, 99};
        
        
        BinarySearchTree bst = new BinarySearchTree();


}
}
