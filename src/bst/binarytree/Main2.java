package bst.binarytree;

import bst.binarytree.BinaryTree;
import bst.binarytree.Node;

//esta clase mostrara los recorridos del arbol
public class Main2 {
    public static void main(String[] args) {
        BinaryTree arbol= new BinaryTree();
        arbol.root = new Node(1);
        arbol.root.left = new Node(2);
        arbol.root.right = new Node(3);
        arbol.root.left.left = new Node(4);
        arbol.root.right.right=new Node(5);

    }
}
