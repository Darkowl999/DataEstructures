package ed2_implementation;

import listas.Nodo;

import java.util.*;

public class ArbolBinarioBusqueda <K extends Comparable<K>,V>implements IArbolBusqueda<K,V>{
    //estos metodos estan sobrecargados de la interface IArbolBusqueda
    protected NodoBinario<K,V> raiz;
    @Override
    public void vaciar() {
        this.raiz= (NodoBinario<K, V>) NodoBinario.nodoVacio();
    }


    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int size() {
        if (this.esArbolVacio()){
            return 0;
        }
        int cantidadDeNodos=0;
        Stack<NodoBinario<K,V>>pilaDeNodo= new Stack<>();
        pilaDeNodo.push(this.raiz);
        while (!pilaDeNodo.isEmpty()){
            NodoBinario<K,V> nodoActual= pilaDeNodo.pop();
            cantidadDeNodos++;
            if (!nodoActual.esVacioHijoDerecho()){
                pilaDeNodo.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()){
                pilaDeNodo.push(nodoActual.getHijoIzquierdo());
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
    public K minimo() {
        if (this.esArbolVacio()){
            return null;
        }
        NodoBinario<K,V> nodoActual= this.raiz;
        NodoBinario<K,V> nodoAnterior=(NodoBinario<K, V>) NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)){
            nodoAnterior=nodoActual;
            nodoActual=nodoActual.getHijoIzquierdo();
        }
        return nodoAnterior.getClave();
    }

    @Override
    public K maximo() {
        return null;
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (claveAInsertar==null){
            throw  new IllegalArgumentException("clave no puede ser nula");
        }
        if (valorAInsertar==null){
            throw new IllegalArgumentException("Valor no puede ser nulo");
        }
        if (this.esArbolVacio()){
            this.raiz=new NodoBinario<>(claveAInsertar,valorAInsertar);
        }
        NodoBinario<K,V> nodoActual= this.raiz; //este nodo es con el que se comparemos
        NodoBinario<K,V> nodoAnterior= (NodoBinario<K, V>) NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual=nodoActual.getClave();
            nodoAnterior=nodoActual;
            if (claveAInsertar.compareTo(claveActual)<0){
                nodoActual=nodoActual.getHijoIzquierdo();
            }else if (claveAInsertar.compareTo(claveActual)>0){
                nodoActual=nodoActual.getHijoDerecho();
            }else{//si la clave ya existe se reemplaza su valor
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
        // se llego hasta este punto quiere decir que no existe en el arbol
        //la clave, entonces debo crear un noodo, con la clave y valor a insertar
        //y el nodoAnterior es el padre del nuevo nodo
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
        if (this.esArbolVacio()) {
            return null;
        }
        NodoBinario<K,V> nodoActual= this.raiz;
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            K claveActual= nodoActual.getClave();
            if (claveABuscar.compareTo(claveActual)==0){
                return nodoActual.getValor();
            }else if (claveABuscar.compareTo(claveActual)<0){
                nodoActual=nodoActual.getHijoIzquierdo();
            }else{
                nodoActual=nodoActual.getHijoIzquierdo();
            }
        }
        // si llego a este punto quiere decir que no se encuentra la clave en el arbol
        return null;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        return null;
    }

    @Override
    public List<K> recorridoEnPreorden() {
        List<K> recorrido= new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Stack<NodoBinario<K,V>> piladeNodo= new Stack<>();
        piladeNodo.push(this.raiz);
        while (!piladeNodo.isEmpty()){
            NodoBinario<K,V> nodoActual= piladeNodo.pop();
            recorrido.add(nodoActual.getClave());

            if (!nodoActual.esVacioHijoDerecho()){
                piladeNodo.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()){
                piladeNodo.push(nodoActual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        return null;
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido= new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }else{
            Queue<NodoBinario<K,V>> coladeNodos= new LinkedList<>();
            coladeNodos.offer(this.raiz);
            while (!coladeNodos.isEmpty()){
                NodoBinario<K,V> nodoActual= coladeNodos.poll();
                recorrido.add(nodoActual.getClave());
                if (!nodoActual.esVacioHijoIzquierdo()){
                    coladeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()){
                    coladeNodos.offer(nodoActual.getHijoDerecho());
                }
            }

        }
        return recorrido;
    }
}
