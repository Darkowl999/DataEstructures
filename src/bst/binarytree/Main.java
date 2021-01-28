package bst.binarytree;

import bst.binarytree.BinaryTree;
import bst.binarytree.Node;

//clase donde llamaremos a la clase BinaryTree
public class Main {
    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        //creo la raiz //
        tree.root= new Node(1);
        /** asi se encuentra el arbol a la hora de ejecutar la linea 7
         *  1
         /     \
        null    null
         */
        tree.root.left= new Node(2);
        tree.root.right=new Node(3);

        /** asi se encuentra el arbol al ejecutar las lineas 13,14
         *   1
          /     \
         2       3
        / \     / \
    null  null null null
         */
        tree.root.left.left= new Node(4);


        tree.printInorder(tree.root);

    }
}
