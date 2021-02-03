package ed2_implementation;

import java.util.List;

public interface IArbolBusqueda<K extends Comparable<K>,V>{

    void vaciar();
    boolean esArbolVacio();
    int size(); //tamaño del arbol
    int altura(); //altura del arbol
    int nivel(); //nivel del arbol
    K minimo();//cual es la clave minima del arbol
    K maximo(); //cual es la clave maxima del arbol
    void insertar(K clave, V valor);
    V eliminar(K clave); //metodo que elimina un balor buscando la clave
    boolean contiene(K clave);
    V buscar(K clave); //busca un valor a traves de la clave en un arbol
    //recorridos// con lista de claves
    List<K> recorridoEnInOrden();
    List<K>recorridoEnPreOrden();
    List<K>recorridoEnPostOrden();
    List<K>recorridoPorNiveles();






}
