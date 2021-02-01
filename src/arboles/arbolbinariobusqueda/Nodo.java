package arboles.arbolbinariobusqueda;

public class Nodo {
    Nodo padre=null;
    Nodo hijoDerecho=null;
    Nodo hijoIzquierdo=null;
    Object valor;
    int llave;
    public Nodo(int llave){
        this.llave=llave;
    }
    //getters y setters//


    public int getLlave() {
        return llave;
    }

    public Nodo getPadre() {
        return padre;
    }
    public Nodo getHijoDerecho(){
        return hijoDerecho;
    }
    public Nodo getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    public Object getValor(){
        return valor;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    public void setHijoDerecho(Nodo hijoDerecho){
        this.hijoDerecho=hijoDerecho;
    }
    public void setHijoIzquierdo(Nodo hijoIzquierdo){
        this.hijoIzquierdo=hijoIzquierdo;
    }
    public void setLlave(int llave) {
        this.llave = llave;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
