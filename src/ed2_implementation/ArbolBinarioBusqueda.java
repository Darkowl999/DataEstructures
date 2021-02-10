package ed2_implementation;

import arboles.arbolbinariobusqueda.Nodo;

import java.util.*;

public class ArbolBinarioBusqueda <K extends Comparable<K>,V> implements IArbolBusqueda<K,V>{
    protected  NodoBinario<K,V> raiz;

    //todo: estos metodos son de la interface
    @Override
    public void vaciar() {
        this.raiz= (NodoBinario<K,V>) NodoBinario.nodoVacio(); //casting
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int size() { //esta funcion se usa para contar la cantidad de nodos de este arbol
        if (this.esArbolVacio()){
            return 0;
        }
        int cantidadDeNodos=0;
        Stack<NodoBinario<K,V>> pilaDeNodos= new Stack<>();
        pilaDeNodos.push(this.raiz);
        while (!pilaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual= pilaDeNodos.pop();
            cantidadDeNodos++;
            //por conveniencia se saca el hijo derecho luego el hijo izquierdo
            if (!nodoActual.esVacioHijoDerecho()){
                pilaDeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()){
                pilaDeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return cantidadDeNodos;
    }
    //altura iterativa//
    public int alturaI(){
        if  (this.esArbolVacio()){
            return 0;
        }
        int alturaDelArbol=0;
        Queue<NodoBinario<K,V>> colaDeNodos= new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            int cantidadDeNodosEnLaCola=colaDeNodos.size();
            int i=0;
            while (i <cantidadDeNodosEnLaCola) {
                NodoBinario<K,V> nodoActual= colaDeNodos.poll();
                if (!nodoActual.esVacioHijoIzquierdo()) {
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()) {
                    colaDeNodos.offer(nodoActual.getHijoDerecho());
                }
                i++;
            }
            alturaDelArbol++;
        }
        return alturaDelArbol;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(NodoBinario<K,V> nodoActual) {//metodo amigo que ayuda al metodo altura
        if (NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int alturaPorIzquierda= altura(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha= altura(nodoActual.getHijoDerecho());
        if(alturaPorIzquierda>alturaPorDerecha){
            return alturaPorIzquierda+1;
        }
        return alturaPorDerecha+1;
    }

    @Override
    public int nivel() { //el nivel es lo mismo que por altura la unica diferencia es que se retorna -1;
        return 0;
    }

    @Override
    public K minimo() { //retorna la clave mas pequeña del arbol binario
        if (this.esArbolVacio()){
            return null;
        }
       NodoBinario<K,V> nodoActual=this.raiz;
       NodoBinario<K,V> nodoAnterior= (NodoBinario<K,V>) NodoBinario.nodoVacio();
       while (!NodoBinario.esNodoVacio(nodoActual)){
           nodoAnterior=nodoActual;
           nodoActual=nodoActual.getHijoIzquierdo();
       }
        return nodoAnterior.getClave();
    }

    @Override
    public K maximo() {//retorna la clave mas grande del arbol binario esta es tarea
        if (this.esArbolVacio()){
            return null;
        }
        NodoBinario<K,V> nodoActual=this.raiz;
        NodoBinario<K,V> nodoAnterior= (NodoBinario<K, V>) NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)){
            nodoAnterior=nodoActual;
            nodoActual=nodoActual.getHijoDerecho();
        }
        return nodoAnterior.getClave();
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (claveAInsertar==null){
            throw  new IllegalArgumentException("CLAVE NO PUEDE SER NULA");
        }
        if (valorAInsertar==null){
            throw  new IllegalArgumentException("EL VALOR NO PUEDE SER NULO");
        }
        if (this.esArbolVacio()){
            this.raiz= new NodoBinario<>(claveAInsertar,valorAInsertar);
            return; //esto corta el método
        }
        NodoBinario<K,V>nodoActual= this.raiz;//todo; raiz
        NodoBinario<K,V> nodoAnterior= (NodoBinario<K, V>) NodoBinario.nodoVacio();//este nodo empieza con el valor de null
        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual= nodoActual.getClave();
            nodoAnterior=nodoActual;
            if (claveAInsertar.compareTo(claveActual)<0){ //comparacion para insertar por izquierda
                nodoActual=nodoActual.getHijoIzquierdo();
            }else if (claveAInsertar.compareTo(claveActual)>0){
                nodoActual=nodoActual.getHijoDerecho();
            }else{ // todo: si la clave existe reemplazo su valor solamente
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
        //una vez llegado hasta este punto, quiere decir que no existe en el arbol
        //la clave, entonces se debe crear un nodo, con la clave y valor a insertar
        //y el nodoAnterior es el padre de ese nuevo nodo
        NodoBinario<K,V> nuevoNodo= new NodoBinario<>(claveAInsertar,valorAInsertar);
        K claveDelPadre= nodoAnterior.getClave();
        if (claveAInsertar.compareTo(claveDelPadre)<0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else{
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }




    }
//Métodos a eliminar //
    /*
    * se toma en cuenta 3 casos para eliminar
    * caso1: Cuando es un nodo hoja es decir sin hijos se lo elimina directamente
    * caso2: Cuando es un nodo que tiene un solo hijo se lo reemplaza por uno de sus hijos
    * caso3: cuando tiene ambos hijos, buscar su sucesor inorden
    * */
    @Override
    public V eliminar(K claveAEliminar) {
        if (claveAEliminar==null){
            throw new IllegalArgumentException("la clave a eliminar no puede ser nula");
        }
        V valorARetornar= this.buscar(claveAEliminar);
        if (valorARetornar==null){
            throw new IllegalArgumentException("La clave no existe en el árbol");
        }
        this.raiz= eliminar(this.raiz, claveAEliminar);

        return valorARetornar;
    }

    //metodo amigo que ayudara al metodo de arriba//
    private NodoBinario<K,V> eliminar(NodoBinario<K,V> nodoActual, K claveAEliminar) {
        K claveActual= nodoActual.getClave();
        if (claveAEliminar.compareTo(claveActual)>0){//si la clave a eliminar es mayor está por la rama derecha
            NodoBinario<K,V> posibleNuevoHijoDerecho= eliminar(nodoActual.getHijoDerecho(),claveAEliminar);
            nodoActual.setHijoDerecho(posibleNuevoHijoDerecho);
            return nodoActual;
        }
        if (claveAEliminar.compareTo(claveActual)>0){//si la clave a eliminar es mayor está por la rama izquierda
            NodoBinario<K,V> posibleNuevoHijoIzquierdo= eliminar(nodoActual.getHijoIzquierdo(),claveAEliminar);
            nodoActual.setHijoIzquierdo(posibleNuevoHijoIzquierdo);
            return nodoActual;
        }
        //si llego a este punto quiere decir que ya lo encontré el nodo con la clave que quiero eliminar
        //caso 1
        if (nodoActual.esHoja()){//en el caso de que sea hoja
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();//simple cast
        }
        //caso 2
        //caso 2.1 -> solo tiene hijo izquierdo
        if (!nodoActual.esVacioHijoIzquierdo()&& nodoActual.esVacioHijoDerecho()){
            return nodoActual.getHijoIzquierdo();
        }
        //caso 2.2 -> solo tiene hijo derecho
        if (!nodoActual.esVacioHijoDerecho()&& nodoActual.esVacioHijoIzquierdo()){
            return nodoActual.getHijoDerecho();
        }
        //caso 3 -> cuando tiene 2 hijos
        NodoBinario<K,V> nodoReemplazo= this.buscarNodoSucesor(nodoActual.getHijoDerecho());

        NodoBinario<K,V> posibleNuevoHijoDerecho=eliminar(nodoActual.getHijoDerecho(),nodoReemplazo.getClave());

        nodoActual.setHijoDerecho(posibleNuevoHijoDerecho);

        nodoActual.setClave(nodoReemplazo.getClave());

        nodoActual.setValor(nodoReemplazo.getValor());


        return nodoActual;

    }
    //este metodo sucesor es metodo amigo y la idea del sucesor es bajar solo por la izquierda
    protected NodoBinario<K,V> buscarNodoSucesor(NodoBinario<K,V> nodoActual) {
        NodoBinario<K,V> nodoAnterior= nodoActual;
        while (!NodoBinario.esNodoVacio(nodoActual)){//puedo hacerlo este recorrido con un do while
            nodoAnterior=nodoActual;
            nodoActual=nodoActual.getHijoIzquierdo();
        }
        return nodoAnterior;
    }

    @Override
    public boolean contiene(K clave) {
        return this.buscar(clave)!=null;
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar==null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }
        if (this.esArbolVacio()){
            return null;
        }
        NodoBinario<K,V> nodoActual= this.raiz; //este nodo actual es basicamente un nodo referencia de la raiz
        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual=nodoActual.getClave();
            if (claveABuscar.compareTo(claveActual)==0){
                return nodoActual.getValor();
            }else if (claveABuscar.compareTo(claveActual)<0){
                nodoActual=nodoActual.getHijoIzquierdo();
            }else{
                nodoActual=nodoActual.getHijoDerecho();
            }
        }
        //si llego a este punto quiere decir que no se encuentra la claveABuscar
        //en el arbol
        return null;
    }
    //TODO: HACER LOS RECORRIDOS EN MODO RECURSIVOS

    @Override
    public List<K> recorridoEnInOrden() { //recorrido en inorden recursivo
        List<K> recorrido= new ArrayList<>();
        //para una implementacion recursiva se necesita un metodo compañero o amigo
        //que haga el grueso del trabajo
        recorridoEnInOrden(this.raiz,recorrido);
        return recorrido;
    }
//Este es el metodo amigo recursivo del recorrido//
    private void recorridoEnInOrden(NodoBinario<K,V> nodoActual, List<K> recorrido) {
        //simulamos el n para un caso base
        if (NodoBinario.esNodoVacio(nodoActual)){//es como decir n igual a cero
            return;
        }
        recorridoEnInOrden(nodoActual.getHijoIzquierdo(),recorrido);
        recorrido.add(nodoActual.getClave());
        recorridoEnInOrden(nodoActual.getHijoDerecho(),recorrido);
    }

    @Override
    public List<K> recorridoEnPreOrden() { //este recorrido se usa pilas
        List<K> recorrido= new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Stack<NodoBinario<K,V>> pilaDeNodos= new Stack<>();
        pilaDeNodos.push(this.raiz);
        while (!pilaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual= pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());
            //por conveniencia se saca el hijo derecho luego el hijo izquierdo
            if (!nodoActual.esVacioHijoDerecho()){
                pilaDeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()){
                pilaDeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K> recorrido= new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Stack<NodoBinario<K,V>> piladeNodos= new Stack<>();
        NodoBinario<K,V> nodoActual=this.raiz;
        //el proceso inicial antes de iterar en la pila
        meterPilaParaPostOrden(piladeNodos, nodoActual);
        //empezamos a iterar sobre la pila
        while (!piladeNodos.isEmpty()){
            nodoActual= piladeNodos.pop();
            recorrido.add(nodoActual.getClave());
            if (!piladeNodos.isEmpty()){
                NodoBinario<K,V> nodoDelTope= piladeNodos.peek();
                if (!nodoDelTope.esVacioHijoDerecho()&&nodoDelTope.getHijoDerecho()!=nodoActual){
                    //volver a hacer el mismo bucle de arriba
                    meterPilaParaPostOrden(piladeNodos,nodoDelTope.getHijoDerecho());
                    
                }
            }

        }
        return recorrido;
    }
//este metodo se lo extrajo del bucle while para hacer un recorrido
    private void meterPilaParaPostOrden(Stack<NodoBinario<K, V>> piladeNodos, NodoBinario<K, V> nodoActual) {
        while (!NodoBinario.esNodoVacio(nodoActual)){
            piladeNodos.push(nodoActual);
            if (!nodoActual.esVacioHijoIzquierdo()){
                nodoActual = nodoActual.getHijoIzquierdo();
            }else{
                nodoActual = nodoActual.getHijoDerecho();
            }

        }
    }
//hacer reconstruir por Preorden es decir hacer ese método
//

    @Override
    public List<K> recorridoPorNiveles() { //recorrido por niveles se usa cola
        List<K> recorrido= new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Queue<NodoBinario<K,V>> colaDeNodos= new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual= colaDeNodos.poll(); //el poll lo que hace es autoeliminarlo y sacarlo cosa que el peek no hace
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoIzquierdo()){
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()){
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return recorrido;
    }

    //otros metodos de la clase//
    //se va a implementar un metodo que retorne si un arbol binario tiene nodos completos, es decir
    //nodos que tengan sus dos hijos diferentes de vacio en el nivel n//

    public  boolean tieneNodosCompletosEnNivel(int nivelObjetivo){
        return tieneNodosCompletosEnNivel(this.raiz,nivelObjetivo,0);

    }

    private boolean tieneNodosCompletosEnNivel(NodoBinario<K,V> nodoActual, int nivelObjetivo, int nivelActual) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return true;
        }

        if (nivelActual== nivelObjetivo){
         return !nodoActual.esVacioHijoIzquierdo()&& !nodoActual.esVacioHijoDerecho();
        }
        boolean completoPorIzquierda=this.tieneNodosCompletosEnNivel(nodoActual.getHijoIzquierdo(),
                nivelObjetivo,nivelActual+1);
        boolean completoPorDerecha=this.tieneNodosCompletosEnNivel(nodoActual.getHijoDerecho(),
                nivelObjetivo,nivelActual+1);
        return completoPorIzquierda && completoPorDerecha;

    }

}
