package bst.binarytree;

import bst.binarytree.Node;

//esta es la clase arbol binario comun
public class BinaryTree {
    Node raiz; //esta es la raiz del arbol binario
    //constructores por defecto//
    BinaryTree(int llave){
        raiz= new Node(llave);
    }
    BinaryTree(){
        raiz=null;
    }
    //Travesias o recorridos de un arbol (inorden, preorden, postorden)

    void printPostOrden(Node nodo){
        if(nodo==null)
            return;
        //hacemos el recorrido de post orden
        printPostOrden(nodo.izquierda);

        printPostOrden(nodo.derecha);
        System.out.println(nodo.llave+ " ");
    }

    void printInorder(Node nodo){
        if(nodo==null)
            return;
        printInorder(nodo.izquierda);
        System.out.println(nodo.llave+ " ");
        printInorder(nodo.derecha);
    }
    void printpreOrden(Node nodo){
        if(nodo==null)
            return;
        System.out.println(nodo.llave+" ");
        printpreOrden(nodo.izquierda);
        printpreOrden(nodo.derecha);

    }


}
