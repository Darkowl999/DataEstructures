package arbolgenerico;
// TODO:K=> hago referencia a key= es decir llave o clave
//TODO:V=> Hago referencia a valor
public class Nodo<K,V> {
    K llave;
    K nodoPadre;
    K hijoIzquierdo;
    K hijoDerecho;
    V valor;

    public Nodo(K llave) {
        this.llave = llave;
    }

    public K getNodoPadre() {
        return nodoPadre;
    }

    public K getHijoDerecho() {
        return hijoDerecho;
    }

    public K getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public K getLlave() {
        return llave;
    }

    public V getValor() {
        return valor;
    }

    public void setNodoPadre(K nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public void setHijoDerecho(K hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijoIzquierdo(K hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setLlave(K llave) {
        this.llave = llave;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
}
