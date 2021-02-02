package arbolesproblemasresueltos;

class Nodo {
    int llave;
    Nodo hijoIzquierdo, hijoDerecho;

    // constructor
    Nodo(int llave)
    {
        this.llave = llave;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

}
