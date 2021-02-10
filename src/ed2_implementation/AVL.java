package ed2_implementation;

import com.sun.corba.se.spi.ior.IdentifiableFactory;

//los unicos metodos que cambian del arbol binario de busqueda con respecto al arbol AVL
//son el eliminar y el insertar nada mas despues es todo lo mismo basicamente
public class AVL<K extends Comparable<K>,V> extends ArbolBinarioBusqueda<K,V>{
    private static final byte DIFERENCIA_MAXIMA=1;//esta es una variable constante

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
        int alturaRamaIzquierda=altura(nodoActual.getHijoIzquierdo());
        int alturaRamaDerecha=altura(nodoActual.getHijoDerecho());
        int diferencia= alturaRamaIzquierda-alturaRamaDerecha;
        
        //SI HAY BALANCE -> IZQUIERDA ES SIMPLE. DERECHA ES DOBLE
        if (diferencia>DIFERENCIA_MAXIMA){
            NodoBinario<K,V>hijoIzquierdo= nodoActual.getHijoIzquierdo();
            alturaRamaIzquierda=altura(hijoIzquierdo.getHijoIzquierdo());
            alturaRamaDerecha=altura(hijoIzquierdo.getHijoDerecho());
            if (alturaRamaDerecha>alturaRamaIzquierda){//siempre que la rama derecha sea mayor a la rama izquierda se rota
                return this.rotacionDobleADerecha(nodoActual); //doble al lado opuesto
            }else{
                return this.rotacionSimpleADerecha(nodoActual);
            }
            
        }else if(diferencia< -DIFERENCIA_MAXIMA){
            NodoBinario<K,V>hijoDerecho= nodoActual.getHijoDerecho();
            alturaRamaDerecha=altura(hijoDerecho.getHijoDerecho());
            alturaRamaIzquierda=altura(hijoDerecho.getHijoIzquierdo());
            if (alturaRamaIzquierda>alturaRamaDerecha){ //siempre que la rama izquuierda sea mayor a la rama derecha se rota
                return this.rotacionDobleAIzquierda(nodoActual);// de manera doble al lado contrario
            }else{
                return this.rotacionSimpleAIzquierda(nodoActual);
            }


        }

        return nodoActual;
    }
    //si es izquierda rota derecha, si es rotacion por derecha rota hijo izquierdo siempre lo contrario
    private NodoBinario<K,V> rotacionSimpleADerecha(NodoBinario<K,V> nodoActual) {
        NodoBinario<K,V> nodoQueRota=nodoActual.getHijoIzquierdo();
        nodoActual.setHijoIzquierdo(nodoQueRota.getHijoDerecho());
        nodoQueRota.setHijoDerecho(nodoActual);
        return nodoQueRota;
    }
    //la rotacion doble está compuesta de una rotación simple pero en vez de rotar el hijo rota el nieto
    private NodoBinario<K,V> rotacionDobleADerecha(NodoBinario<K,V> nodoActual) {
        nodoActual.setHijoIzquierdo(rotacionSimpleAIzquierda(nodoActual.getHijoIzquierdo()));
        return this.rotacionSimpleADerecha(nodoActual);
    }

    private NodoBinario<K,V> rotacionSimpleAIzquierda(NodoBinario<K,V> nodoActual) {
        NodoBinario<K,V> nodoQueRota= nodoActual.getHijoDerecho();
        nodoActual.setHijoDerecho(nodoQueRota.getHijoIzquierdo());
        nodoQueRota.setHijoIzquierdo(nodoActual);
        return nodoQueRota;
    }
    private NodoBinario<K,V> rotacionDobleAIzquierda(NodoBinario<K,V> nodoActual) {
        nodoActual.setHijoDerecho(rotacionSimpleADerecha(nodoActual.getHijoDerecho()));
        return this.rotacionSimpleAIzquierda(nodoActual);
    }


}
