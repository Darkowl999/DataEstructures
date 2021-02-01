package arbolesproblemasresueltos;

public class Nodo {
    Nodo padre=null;
    Nodo hijoIzquierdo=null;
    Nodo hijoDerecho= null;
    Object valor;
    int llave;
    public Nodo(int llave,Object valor){
        this.llave=llave;
        this.valor=valor;
    }
    public Nodo(int llave){
        this.llave=llave;
    }

    public int getLlave() {
        return llave;
    }

    public Object getValor() {
        return valor;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
}
