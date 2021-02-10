package ed2_implementation;

import com.sun.corba.se.spi.ior.IdentifiableFactory;

//los unicos metodos que cambian del arbol binario de busqueda con respecto al arbol AVL
//son el eliminar y el insertar nada mas despues es todo lo mismo basicamente
public class AVL<K extends Comparable<K>,V> extends ArbolBinarioBusqueda<K,V>{
    private static final byte DIFERENCIA_MAXIMA=1;

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (claveAInsertar == null) {
            throw new IllegalArgumentException("CLAVE NO PUEDE SER NULA");
        }
        if (valorAInsertar == null) {
            throw new IllegalArgumentException("VALOR NO PUEDE SER NULA");
        }
        if (super.contiene(claveAInsertar)) {
            throw new RuntimeException("CLAVE YA EXISTE");
        }
        super.raiz=insertar(this.raiz,claveAInsertar,valorAInsertar);

    }
    //metodo amigo que ayuda al metodo insertar de la clase
    private NodoBinario<K,V> insertar(NodoBinario<K,V> nodoActual, K claveAInsertar, V valorAInsertar) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            NodoBinario<K,V> nuevoNodo=new NodoBinario<>(claveAInsertar,valorAInsertar);
            return nuevoNodo;
        }
        K claveActual= nodoActual.getClave();
        if (claveAInsertar.compareTo(claveActual)>0){
            NodoBinario<K,V> supuestoNuevoHijoDerecho= insertar(nodoActual.getHijoDerecho(),claveAInsertar,valorAInsertar);
            nodoActual.setHijoDerecho(supuestoNuevoHijoDerecho);
            return this.balancear(nodoActual);
        }
        if (claveAInsertar.compareTo(claveActual)<0){
            NodoBinario<K,V> supuestoNuevoHijoIzquierdo= insertar(nodoActual.getHijoIzquierdo(),claveAInsertar,valorAInsertar);
            nodoActual.setHijoIzquierdo(supuestoNuevoHijoIzquierdo);
            return this.balancear(nodoActual);
        }
        //si llego acá quiere decir que en el nodo actual esta la clave a insertar
        nodoActual.setValor(valorAInsertar);
        return nodoActual;
    }

    private NodoBinario<K,V> balancear(NodoBinario<K,V> nodoActual) {
        return nodoActual;

    }











}
