package listas;
/***
 * El nodo como tal tiene 2 elementos:
 *  el campo informacion -> Es el que guarda los valores o tipos de datos
 *  el enlace o siguiente -> es un enlace o punetero que enlaza al siguiente enlace
 * ***/
public class Nodo {
    Object valor; //este es el valor que almacenara el nodo
    Nodo siguiente= null; //este es el enlace o puntero que conecta a otro nodo

    public Nodo(Object valor){ //Constructor de oficio
        this.valor=valor;
        this.siguiente=null;
    }
    //Metodos

    public Object obtenerValor(){//este metodo retorna el valor del nodo

        return valor;
    }

    public void enlazarSiguiente(Nodo nodo){ //Este método conecta a otro nodo

        siguiente=nodo;
    }
    public Nodo obtenerSiguiente() { //este método basicamente se encarga de mostrar el siguiente nodo que esta siendo apuntado.
        return siguiente;

    }


}
