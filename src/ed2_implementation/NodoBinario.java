package ed2_implementation;
public class NodoBinario <K,V>{
    private K clave; //clave o llave de un nodo
    private V valor; //valor que tendrá el nodo
    private NodoBinario<K,V> hijoIzquierdo; //hijo izquierdo
    private NodoBinario<K,V> hijoDerecho;// hijo derecho
    //todo: constructores por defecto
    public NodoBinario(){
    }
    public NodoBinario(K clave, V valor){
        this.clave=clave;
        this.valor=valor;
    }
    //todo; getters and setters

    public V getValor() {
        return valor;
    }

    public K getClave() {
        return clave;
    }

    public NodoBinario<K, V> getHijoDerecho() {
        return hijoDerecho;
    }

    public NodoBinario<K, V> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public void setHijoDerecho(NodoBinario<K, V> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijoIzquierdo(NodoBinario<K, V> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
    //todo: metodos propios del nodo
    public boolean esVacioHijoIzquierdo(){
        return NodoBinario.esNodoVacio(this.getHijoIzquierdo());

    }
    public boolean esVacioHijoDerecho(){
        return NodoBinario.esNodoVacio(this.getHijoDerecho());

    }
    public boolean esHoja(){
        return this.esVacioHijoIzquierdo()&& this.esVacioHijoDerecho();
    }
    //metodo compartido
    public static boolean esNodoVacio(NodoBinario nodo){
        return nodo==NodoBinario.nodoVacio();
    }
    public boolean esNodocompleto(){// un nodo completo es cuando tiene ambos hijos
        return !this.esVacioHijoIzquierdo() && !this.esVacioHijoDerecho();
    }
    public static NodoBinario<?,?>nodoVacio(){
        return null;
    }
}
