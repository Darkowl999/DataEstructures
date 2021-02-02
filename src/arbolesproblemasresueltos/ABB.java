package arbolesproblemasresueltos;

import java.util.LinkedList;
import java.util.Queue;

public class ABB{
    static Nodo raiz; //nodo raiz del arbol binario

    /* Inorder traversal of a binary tree*/
    static void inorder(Nodo temp) //recorrido inorden
    {
        if (temp == null)
            return;

        inorder(temp.hijoIzquierdo);
        System.out.print(temp.llave + " ");
        inorder(temp.hijoDerecho);
    }

    /*funcion que inserta un elemento en un arbol binario */
    static void insert(Nodo nodoaInsertar, int llave)
    {
        if (nodoaInsertar == null) {
            raiz = new Nodo(llave);
            return;
        }
        Queue<Nodo> coladeNodos = new LinkedList<Nodo>();
        coladeNodos.add(nodoaInsertar);

        // Do level order traversal until we find
        // an empty place.
        while (!coladeNodos.isEmpty()) {
            nodoaInsertar = coladeNodos.peek();
            coladeNodos.remove();

            if (nodoaInsertar.hijoIzquierdo == null) {
                nodoaInsertar.hijoIzquierdo = new Nodo(llave);
                break;
            }
            else
                coladeNodos.add(nodoaInsertar.hijoIzquierdo);

            if (nodoaInsertar.hijoDerecho == null) {
                nodoaInsertar.hijoDerecho = new Nodo(llave);
                break;
            }
            else
                coladeNodos.add(nodoaInsertar.hijoDerecho);
        }
    }

// Función para borrar el nodo más profundo por derecha
// elemento en árbol binario
    public void eliminarmasProfundo(Nodo raiz, Nodo nodoaEliminar){
        Queue<Nodo> coladeNodos= new LinkedList<Nodo>();
        coladeNodos.add(raiz);
        Nodo nodoTemporal=null;
        while (!coladeNodos.isEmpty()){
            nodoTemporal= coladeNodos.peek();
            coladeNodos.remove();
            if (nodoTemporal==nodoaEliminar){
                nodoTemporal=null;
                return;
            }
            if (nodoTemporal.hijoDerecho!=null){
                if (nodoTemporal.hijoDerecho==nodoaEliminar){
                    nodoTemporal.hijoDerecho=null;
                    return;
                }
                else
                    coladeNodos.add(nodoTemporal.hijoDerecho);
            }
            if (nodoTemporal.hijoIzquierdo!=null){
                if (nodoTemporal.hijoIzquierdo==nodoaEliminar){
                    nodoTemporal.hijoIzquierdo=null;
                    return;
                }
                else
                    coladeNodos.add(nodoTemporal.hijoIzquierdo);
            }
        }
    }

// Función para borrar un elemento dado
// en árbol binario
    public void eliminar(Nodo raiz, int llave){
        if (raiz==null)
            return;
        if (raiz.hijoIzquierdo==null && raiz.hijoDerecho==null){
            if (raiz.llave==llave)
                return;
            else
                return;
        }
        Queue<Nodo> coladeNodos= new LinkedList<Nodo>();
        coladeNodos.add(raiz);
        Nodo nodoTemporal= null, llaveNodo=null;
        while (!coladeNodos.isEmpty()){
            nodoTemporal=coladeNodos.peek();
            coladeNodos.remove();
            if (nodoTemporal.llave==llave)
                llaveNodo=nodoTemporal;
            if (nodoTemporal.hijoIzquierdo!=null)
                coladeNodos.add(nodoTemporal.hijoIzquierdo);
        }
        if (llaveNodo!=null){
            int x= nodoTemporal.llave;
            eliminarmasProfundo(raiz,nodoTemporal);
            llaveNodo.llave=x;
        }

    }







}
