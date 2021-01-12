package arboles;

public class ArbolBinarioBusqueda {

    Nodo raiz; //este será el punto de partido del arbol
    public ArbolBinarioBusqueda(){
        raiz=null;
    }
    //metodos//

    public void recorridoenOrden(Nodo x){
        if (x!= null){
            recorridoenOrden(x.hijoIzquierdo);
            System.out.println(x.valor);
            recorridoenOrden(x.hijoDerecho);
        }

    }




    public void insertar(int key,Object valor){
        Nodo nuevoNodo= new Nodo(key);
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

}

class Nodo {

    public Nodo padre; //padre del nodo o raiz
    public Nodo hijoDerecho;//hijo derecho
    public Nodo hijoIzquierdo; //hijo izquierdo del arbol
    public int llave; //Llave del arbol
    public Object valor; //valor que almacenará

    public Nodo(int key){
        llave=key;
        hijoDerecho=null;
        hijoIzquierdo=null;
        padre=null;
        valor=null;
    }
}


