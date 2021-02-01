package arboles;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {

    Nodo raiz; //este será el punto de partido del arbol
    public ArbolBinario(){
        raiz=null;
    }
    //metodos//

    //recorridos de un arbol binario
    public void recorridoenOrden(Nodo nodoaInsertar){
        if (nodoaInsertar != null){
            recorridoenOrden(nodoaInsertar.hijoIzquierdo);
            System.out.println(nodoaInsertar.valor);
            recorridoenOrden(nodoaInsertar.hijoDerecho);
        }

    }
    public void recorridopostOrden(Nodo nodoaInsertar){
        if (nodoaInsertar!=null){
            recorridopostOrden(nodoaInsertar.hijoIzquierdo);
            recorridopostOrden(nodoaInsertar.hijoDerecho);
            System.out.println(nodoaInsertar.valor+" ");
        }

    }
    public void recorridopreOrden(Nodo nodoaInsertar){
        if (nodoaInsertar!=null){
            System.out.println(nodoaInsertar.valor=" ");
            recorridopreOrden(nodoaInsertar.hijoIzquierdo);
            recorridopreOrden(nodoaInsertar.hijoDerecho);

        }
    }





    public void insertarNodo(int llave,Object valor){
        Nodo nuevoNodo= new Nodo(llave);
        nuevoNodo.valor=valor;
        if (raiz==null){
            raiz=nuevoNodo;
        }else{
            Nodo nodoTemporal = raiz;
            while (nodoTemporal!=null){//Este ciclo lo unico que hace es recorrer el arbol
                nuevoNodo.padre=nodoTemporal;
                if (nuevoNodo.llave>= nodoTemporal.llave){
                    nodoTemporal=nodoTemporal.hijoDerecho;
                }else{
                    nodoTemporal=nodoTemporal.hijoIzquierdo;
                }
            }
            if (nuevoNodo.llave<=nuevoNodo.padre.llave){
                nuevoNodo.padre.hijoIzquierdo=nuevoNodo;
            }else {
                nuevoNodo.padre.hijoDerecho=nuevoNodo;
            }

        }

    }

    //Metodo para eliminar//







}















class Nodo {

    public Nodo padre; //padre del nodo o raiz
    public Nodo hijoDerecho;//hijo derecho
    public Nodo hijoIzquierdo; //hijo izquierdo del arbol
    public int llave; //Llave del arbol
    public Object valor; //valor que almacenará
//Constructor de la clase nodo
    public Nodo(int key){
        llave=key;
        hijoDerecho=null;
        hijoIzquierdo=null;
        padre=null;
        valor=null;
    }
    public Nodo(){
        this.llave=llave;
        this.hijoDerecho=hijoDerecho=null;
        this.hijoIzquierdo=hijoIzquierdo=null;
        this.padre=padre=null;
        this.valor=valor=null;
    }
}


