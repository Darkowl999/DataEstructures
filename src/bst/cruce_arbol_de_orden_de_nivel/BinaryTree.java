package bst.cruce_arbol_de_orden_de_nivel;

//Programa racursivo pof nivel
//order traversal of binary tree

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root; //raiz
    public BinaryTree(){
        root=null;
    }
    //función para imprimir el orden de nivel transversal del árbol es decir in orden
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
//este metodo lo que hace es calcular la altura del arbol
int height(Node root)
{
    if (root == null)
        return 0;
    else
    {
        /* compute  height of each subtree */
        int lheight = height(root.left);
        int rheight = height(root.right);

        /* use the larger one */
        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);
    }
}

    //Imprimir nodos en el nivel dado
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.dato + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    //Inserción en un árbol binario en orden de nivel

    //creo el metodo de recorrido inorden//

    public static void inorden(Node temporal){
        Node root=null;
        temporal=root;
        if (temporal==null)
            return;
        inorden(temporal.left);
         System.out.println(temporal.dato +" ");
         inorden(temporal.right);
    }
    //metodo para insertar//
  public static void insertar(Node temporal, int llave){
        Node root=null;
        temporal=root;
        if (temporal==null){
            root= new Node(llave);
            return;
        }
        //creo una cola//
        Queue<Node> cola= new LinkedList<Node>();
        cola.add(temporal);
        //Hacer un recorrido de orden de nivel hasta que encontremos un lugar vacío
        while (!cola.isEmpty()){
            temporal=cola.peek();
            cola.remove();

            if (temporal.left==null){
                temporal= new Node(llave);
                break;
            }
            else
                cola.add(temporal.left);
                if (temporal.right==null){
                    temporal.right= new Node(llave);
                    break;
                }
                else
                    cola.add(temporal.right);


        }

    }



}
class Node{
    int dato;
    Node left,right;
    //constructor
    public Node(int dato){
        this.dato=dato;
        left=right=null;
    }
}
