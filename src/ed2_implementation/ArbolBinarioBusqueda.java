package ed2_implementation;

import java.util.*;

public class ArbolBinarioBusqueda <K extends Comparable<K>,V> implements IArbolBusqueda<K,V>{
    protected  NodoBinario<K,V> raiz;
    //todo: estos metodos son de la interface
    @Override
    public void vaciar() {
        this.raiz= (NodoBinario<K,V>) NodoBinario.nodoVacio(); //casting
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int size() { //esta funcion se usa para contar la cantidad de nodos de este arbol
        if (this.esArbolVacio()){
            return 0;
        }
        int cantidadDeNodos=0;
        Stack<NodoBinario<K,V>> pilaDeNodos= new Stack<>();
        pilaDeNodos.push(this.raiz);
        while (!pilaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual= pilaDeNodos.pop();
            cantidadDeNodos++;
            //por conveniencia se saca el hijo derecho luego el hijo izquierdo
            if (!nodoActual.esVacioHijoDerecho()){
                pilaDeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()){
                pilaDeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return cantidadDeNodos;
    }

    @Override
    public int altura() {
        return 0;
    }

    @Override
    public int nivel() {
        return 0;
    }

    @Override
    public K minimo() { //retorna la clave mas pequeña del arbol binario
        if (this.esArbolVacio()){
            return null;
        }
       NodoBinario<K,V> nodoActual=this.raiz;
       NodoBinario<K,V> nodoAnterior= (NodoBinario<K, V>) NodoBinario.nodoVacio();
       while (!NodoBinario.esNodoVacio(nodoActual)){
           nodoAnterior=nodoActual;
           nodoActual=nodoActual.getHijoIzquierdo();
       }
        return nodoAnterior.getClave();
    }

    @Override
    public K maximo() {//retorna la clave mas grande del arbol binario esta es tarea
        if (this.esArbolVacio()){
            return null;
        }
        NodoBinario<K,V> nodoActual=this.raiz;
        NodoBinario<K,V> nodoAnterior= (NodoBinario<K, V>) NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)){
            nodoAnterior=nodoActual;
            nodoActual=nodoActual.getHijoDerecho();
        }
        return nodoAnterior.getClave();
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (claveAInsertar==null){
            throw  new IllegalArgumentException("CLAVE NO PUEDE SER NULA");
        }
        if (valorAInsertar==null){
            throw  new IllegalArgumentException("EL VALOR NO PUEDE SER NULO");
        }
        if (this.esArbolVacio()){
            this.raiz= new NodoBinario<>(claveAInsertar,valorAInsertar);
            return; //esto corta el método
        }
        NodoBinario<K,V>nodoActual= this.raiz;//todo; raiz
        NodoBinario<K,V> nodoAnterior= (NodoBinario<K, V>) NodoBinario.nodoVacio();//este nodo empieza con el valor de null
        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual= nodoActual.getClave();
            nodoAnterior=nodoActual;
            if (claveAInsertar.compareTo(claveActual)<0){ //comparacion para insertar por izquierda
                nodoActual=nodoActual.getHijoIzquierdo();
            }else if (claveAInsertar.compareTo(claveActual)>0){
                nodoActual=nodoActual.getHijoDerecho();
            }else{ // todo: si la clave existe reemplazo su valor solamente
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
        //una vez llegado hasta este punto, quiere decir que no existe en el arbol
        //la clave, entonces se debe crear un nodo, con la clave y valor a insertar
        //y el nodoAnterior es el padre de ese nuevo nodo
        NodoBinario<K,V> nuevoNodo= new NodoBinario<>(claveAInsertar,valorAInsertar);
        K claveDelPadre= nodoAnterior.getClave();
        if (claveAInsertar.compareTo(claveDelPadre)<0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else{
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }




    }

    @Override
    public V eliminar(K clave) {
        return null;
    }

    @Override
    public boolean contiene(K clave) {
        return this.buscar(clave)!=null;
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar==null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }
        if (this.esArbolVacio()){
            return null;
        }
        NodoBinario<K,V> nodoActual= this.raiz; //este nodo actual es basicamente un nodo referencia de la raiz
        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual=nodoActual.getClave();
            if (claveABuscar.compareTo(claveActual)==0){
                return nodoActual.getValor();
            }else if (claveABuscar.compareTo(claveActual)<0){
                nodoActual=nodoActual.getHijoIzquierdo();
            }else{
                nodoActual=nodoActual.getHijoDerecho();
            }
        }
        //si llego a este punto quiere decir que no se encuentra la claveABuscar
        //en el arbol
        return null;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        return null;
    }

    @Override
    public List<K> recorridoEnPreOrden() { //este recorrido se usa pilas
        List<K> recorrido= new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Stack<NodoBinario<K,V>> pilaDeNodos= new Stack<>();
        pilaDeNodos.push(this.raiz);
        while (!pilaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual= pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());
            //por conveniencia se saca el hijo derecho luego el hijo izquierdo
            if (!nodoActual.esVacioHijoDerecho()){
                pilaDeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()){
                pilaDeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        return null;
    }

    @Override
    public List<K> recorridoPorNiveles() { //recorrido por niveles se usa cola
        List<K> recorrido= new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Queue<NodoBinario<K,V>> colaDeNodos= new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual= colaDeNodos.poll(); //el poll lo que hace es autoeliminarlo y sacarlo cosa que el peek no hace
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoIzquierdo()){
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()){
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return recorrido;
    }
}
