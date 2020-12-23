package practicasEd2_ing;
/**Esta es una clase implementada en la clase del ing Vacapinto**/
public class NodoBinario <K,V>{
    private K clave;
    private V valor;
    private NodoBinario<K,V> hijoIzquierdo;
    private NodoBinario<K,V> hijoDerecho;
    public NodoBinario(){

    }
    public NodoBinario(K clave, V valor){
        this.clave=clave;
        this.valor=valor;
    }

    public K getClave() {
        return clave;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public NodoBinario<K, V> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario<K, V> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public NodoBinario<K, V> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario<K, V> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
    //METODOS PROPIOS//
    public boolean esVacioHijoIzquierdo(){
        return NodoBinario.esNodoVacio(this.getHijoIzquierdo());
    }
    public boolean esVacioHijoDerecho(){
        return NodoBinario.esNodoVacio(this.getHijoDerecho());

    }
    public boolean esHoja(){
        return this.esVacioHijoIzquierdo()&& this.esVacioHijoDerecho();
    }

    public static boolean esNodoVacio(NodoBinario nodo){
        return nodo== null;
    }
    public static NodoBinario<?,?> nodoVacio(){
        return null;
    }


}
