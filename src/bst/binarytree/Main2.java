package bst.binarytree;

import bst.binarytree.BinaryTree;
import bst.binarytree.Node;

//esta clase mostrara los recorridos del arbol
public class Main2 {
    public static void main(String[] args) {
        BinaryTree arbol= new BinaryTree();
        arbol.raiz = new Node(1);
        arbol.raiz.izquierda = new Node(2);
        arbol.raiz.derecha = new Node(3);
        arbol.raiz.izquierda.izquierda = new Node(4);
        arbol.raiz.izquierda.derecha=new Node(5);
        arbol.printpreOrden(arbol.raiz);

    }
}
