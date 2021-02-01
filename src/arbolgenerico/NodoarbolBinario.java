package arbolgenerico;

public class NodoarbolBinario <T extends Comparable<T>> {
    private T elemento; //vendria a ser como la llave o el valor mas o menos
    private NodoarbolBinario<T> padre;
    private NodoarbolBinario<T> hijoIzquierdo;
    private NodoarbolBinario<T> hijoDerecho;
    //constructores de oficio//
    public NodoarbolBinario(T elemento){
        this.elemento=elemento;
    }
    public NodoarbolBinario(T elemento,NodoarbolBinario<T>padre,NodoarbolBinario<T>hijoIzquierdo,NodoarbolBinario<T>hijoDerecho){
        this.elemento=elemento;
        this.padre=padre;
        this.hijoDerecho=hijoDerecho;
        this.hijoIzquierdo=hijoIzquierdo;
    }

    //getter and setters


    public T getElemento() {
        return elemento;
    }

    public NodoarbolBinario<T> getPadre() {
        return padre;
    }

    public NodoarbolBinario<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public NodoarbolBinario<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setPadre(NodoarbolBinario<T> padre) {
        this.padre = padre;
    }

    public void setHijoDerecho(NodoarbolBinario<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijoIzquierdo(NodoarbolBinario<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
}
