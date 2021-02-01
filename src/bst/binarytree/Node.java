package bst.binarytree;
//esta clase es la clase nodo que se ocupa comunmente en un arbol binario
public class Node {
    int llave;
    Node izquierda,derecha; //left=Izquierda,right=derecha, estos son los hijos
    //constructor por defecto de la clase//
    public Node(int llave){
        this.llave=llave;
        izquierda=derecha=null; //inicializo ambos hijos en null

    }
}
