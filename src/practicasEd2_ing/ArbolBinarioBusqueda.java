package practicasEd2_ing;
import java.util.List;

public class ArbolBinarioBusqueda <K extends Comparable<K>,V > implements IArbolBusqueda<K,V> {
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
        return 0;
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
        return null;
    }

    @Override
    public K maximo() {
        return null;
    }

    @Override
    public void insertar(K clave, V valor) {
        if (clave == null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }
        if (valor == null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }

        if (this.esArbolVacio()){
            this.raiz= new NodoBinario<>(clave,valor);
            return ;
        }
        NodoBinario<K,V> nodoActual=this.raiz;
        NodoBinario<K,V> NodoAnterior=(NodoBinario<K, V>) NodoBinario.nodoVacio() ;
        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual= nodoActual.getClave();

        }


    }

    @Override
    public V eliminar(K clave) {
        return null;
    }

    @Override
    public boolean contiene(K clave) {
        return false;
    }

    @Override
    public V buscar(K clave) {
        return null;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        return null;
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        return null;
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        return null;
    }

    @Override
    public List<K> recorridosPorNiveles() {
        return null;
    }
}
