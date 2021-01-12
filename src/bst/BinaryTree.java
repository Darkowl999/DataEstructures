package bst;
//esta es la clase arbol binario comun
public class BinaryTree {
    Node root; //esta es la raiz del arbol binario
    //constructores por defecto//
    BinaryTree(int llave){
        root= new Node(llave);
    }
    BinaryTree(){
        root=null;
    }
    //Travesias o recorridos de un arbol (inorden, preorden, postorden)

    void printPostOrden(Node nodo){
        if(nodo==null)
            return;
        //hacemos el recorrido de post orden
        printPostOrden(nodo.left);

        printPostOrden(nodo.right);
        System.out.println(nodo.key+ " ");
    }

    void printInorder(Node nodo){
        if(nodo==null)
            return;
        printInorder(nodo.left);
        System.out.println(nodo.key+ " ");
        printInorder(nodo.right);
    }
    void printpreOrden(Node nodo){
        if(nodo==null)
            return;
        System.out.println(nodo.key+" ");
        printpreOrden(nodo.left);
        printpreOrden(nodo.right);

    }


}
