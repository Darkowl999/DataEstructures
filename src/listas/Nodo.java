package listas;
/***
 * El nodo como tal tiene 2 elementos:
 *  el campo informacion -> Es el que guarda los valores o tipos de datos
 *  el enlace o siguiente -> es un enlace o punetero que enlaza al siguiente enlace
 * ***/
public class Nodo {
    Object valor;
    Nodo siguiente= null;

    public Nodo(Object valor){
        this.valor=valor;
        this.siguiente=null;
    }
    //Metodos

    public Object obtenerValor(){
        return valor;
    }

    public void enlazarSiguiente(Nodo nodo){
        siguiente=nodo;
    }
    public Nodo obtenerSiguiente(){
        return siguiente;
    }


}
