package arboles.arbolbinariobusqueda;

public class ArbolBinarioBusqueda {
    Nodo raiz; //esta es la raiz del arbol

    public ArbolBinarioBusqueda(){
        raiz=null;
    }
    //metodos
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    //insertar//
    public void insertarNodo(int llave,Object valor){
        Nodo nuevoNodoaInsertar=new Nodo(llave);
        nuevoNodoaInsertar.valor=valor;
        if (raiz==null){//caso 1 si es que el arbol esta vacío
            nuevoNodoaInsertar=raiz;
        }else{ //caso 2 si el arbol no esta vacio se hace un recorrido
            Nodo nodoTemporal=raiz;
            while (nodoTemporal!=null){
                nuevoNodoaInsertar.padre=nodoTemporal;
                if (nuevoNodoaInsertar.llave>= nodoTemporal.llave){
                    nodoTemporal=nodoTemporal.hijoDerecho;

                }else{
                    nodoTemporal=nodoTemporal.hijoIzquierdo;
                }
            }
            if (nuevoNodoaInsertar.llave<= nuevoNodoaInsertar.padre.llave){
                nuevoNodoaInsertar.padre.hijoIzquierdo=nuevoNodoaInsertar;
            }else{
                nuevoNodoaInsertar.padre.hijoDerecho=nuevoNodoaInsertar;
            }
        }
    }
    // TODO: BUSQUEDAS NO INFORMADAS
    //Busquedas en profundidad
    //preorden//
    public void recorridoPreorden( Nodo nodo){
        if (nodo==null)
            return;
        System.out.println("Valor nodo =>"+ nodo.getValor());
        recorridoPreorden(nodo.hijoIzquierdo);
        recorridoPreorden(nodo.hijoDerecho);
    }
    //postorden//
    public void recorridoPostorden(Nodo nodo){
        if (nodo==null)
            return;
        recorridoPostorden(nodo.hijoIzquierdo);
        recorridoPostorden(nodo.hijoDerecho);
        System.out.println("Valor nodo =>"+ nodo.getValor());
    }
    //inorden//
    public void recorridoInorden(Nodo nodo){
        if (nodo==null)
            return;
        recorridoInorden(nodo.hijoIzquierdo);
        System.out.println("Valor nodo=>"+ nodo.getValor());
        recorridoInorden(nodo.hijoIzquierdo);

    }


    //eliminar//

}
