package bst;
//esta clase es la clase nodo que se ocupa comunmente en un arbol binario
public class Node {
    int key;
    Node left, right; //left=Izquierda,right=derecha, estos son los hijos
    //constructor por defecto de la clase//
    public Node(int llave){
        this.key=llave;
        left=right=null; //inicializo ambos hijos en null

    }
}
