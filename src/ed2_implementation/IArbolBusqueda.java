package ed2_implementation;

import java.util.List;

//ver que son las interfaces en java
public interface IArbolBusqueda <K extends Comparable<K>,V>{

    //metodos
    void vaciar();
    boolean esArbolVacio();
    int size();//tamaño del arbol
    int altura();//altura del arbol
    int nivel();//nivel?
    K minimo();
    K maximo();
    void insertar(K clave,V valor);
    V eliminar(K clave);
    boolean contiene(K clave);
    V buscar(K clave);
    List<K> recorridoEnInOrden();
    List<K>recorridoEnPreorden();
    List<K>recorridoEnPostOrden();
    List<K>recorridoPorNiveles();


    


}
