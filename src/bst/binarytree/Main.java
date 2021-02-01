package bst.binarytree;

import bst.binarytree.BinaryTree;
import bst.binarytree.Node;

//clase donde llamaremos a la clase BinaryTree
public class Main {
    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        //creo la raiz //
        tree.raiz= new Node(1);
        /** asi se encuentra el arbol a la hora de ejecutar la linea 7
         *  1
         /     \
        null    null
         */
        tree.raiz.izquierda= new Node(2);
        tree.raiz.izquierda=new Node(3);

        /** asi se encuentra el arbol al ejecutar las lineas 13,14
         *   1
          /     \
         2       3
        / \     / \
    null  null null null
         */
        tree.raiz.izquierda.izquierda= new Node(4);


        tree.printInorder(tree.raiz);

    }
}
