package arbolesproblemasresueltos;

import java.util.LinkedList;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
       /* ABB arbol= new ABB();
        Nodo raiz = new Nodo(10);
        raiz.hijoIzquierdo = new Nodo(11);
        raiz.hijoIzquierdo.hijoIzquierdo = new Nodo(7);
        raiz.hijoDerecho = new Nodo(9);
        raiz.hijoDerecho.hijoIzquierdo = new Nodo(15);
        raiz.hijoDerecho.hijoDerecho = new Nodo(8);

        System.out.print("Travesia inorden antes de la insercion"+" => ");
        arbol.inorder(raiz);

        int key = 12;
        arbol.insert(raiz,12);
        System.out.println("\n aca inserto una nueva llave de valor 12 ");

        System.out.print("\n travesia inorden despuesde la insercion"+" => ");
        arbol.inorder(raiz);*/
        ABB arbol= new ABB();
        Nodo raiz=new Nodo(10);
         raiz.hijoIzquierdo=new Nodo(11);
         raiz.hijoIzquierdo.hijoIzquierdo=new Nodo(7);
         raiz.hijoIzquierdo.hijoDerecho=new Nodo(12);
         raiz.hijoDerecho=new Nodo(9);
         raiz.hijoDerecho.hijoIzquierdo=new Nodo(15);
         raiz.hijoDerecho.hijoDerecho=new Nodo(8);
        System.out.println("travesia en orden antes de la eliminacion");
        arbol.inorder(raiz);
        int llave=11;
        arbol.eliminar(raiz,llave);
        System.out.println("\n travesia inorden despues de la eliminacion");
        arbol.inorder(raiz);

    }

}
