package arbolgenerico;

//metodos mas comunes iniciales en un arbol binario//
public class ArbolbinarioBusqueda<T extends Comparable<T>> {
    private NodoarbolBinario<T> raiz;//es el primero o el origen

    //metodos:
    public boolean esArbolVacio(){
        return raiz==null;
    }

    public NodoarbolBinario<T> getRaiz() {
        return raiz;
    }

    public boolean esRaiz(NodoarbolBinario<T> nodo){
        return raiz==nodo;
    }

    public boolean esHoja(NodoarbolBinario<T> nodo){// retorna verdadero si es un nodo hoja y falso si no es un nodo hoja
        return nodo.getHijoIzquierdo()==null && nodo.getHijoDerecho()==null;
    }
    public boolean esnodoInterno(NodoarbolBinario<T> nodo){//retorna verdadero si ese nodo es interno es decir si el nodo tiene hijos
        return !esHoja(nodo);
    }
    //Insertar Nodos o insertar nuevos elementos al arbol

    //insertar nodos de manera recursiva
    public void insertarR(NodoarbolBinario<T> origen,T elemento){
        if (raiz==null){
            raiz=new NodoarbolBinario<T>(elemento);

        }else if(origen==null){
            System.out.println("El origen es nulo");
        }else{
            if (origen.getElemento().compareTo(elemento)>0){
                if (origen.getHijoIzquierdo()!=null){
                    insertarR(origen.getHijoIzquierdo(),elemento);
                }else{
                    NodoarbolBinario<T> nodo= new NodoarbolBinario<T>(elemento);
                    nodo.setPadre(origen);
                    origen.setHijoIzquierdo(nodo);
                }
            }else{
                if (origen.getHijoDerecho()!=null){
                    insertarR(origen.getHijoDerecho(),elemento);
                }else{
                    NodoarbolBinario<T> nodo= new NodoarbolBinario<T>(elemento);
                    nodo.setPadre(origen);
                    origen.setHijoDerecho(nodo);
                }

            }

        }

    }
    //insertar nodos de manera iterativa =  QUEDA PENDIENTE
    //recorridos//
    public void recorridoPreorden(NodoarbolBinario<T> nodo){
        System.out.println(nodo.getElemento().toString());
        if (nodo.getHijoIzquierdo()!=null){
            recorridoPreorden(nodo.getHijoIzquierdo());
        }
        if(nodo.getHijoDerecho()!=null){
            recorridoPreorden(nodo.getHijoDerecho());
        }
    }
    public void recorridoInorden(NodoarbolBinario<T> nodo){

        if (nodo.getHijoIzquierdo()!=null){
            recorridoPreorden(nodo.getHijoIzquierdo());

        }
        System.out.println(nodo.getElemento().toString());
        if (nodo.getHijoDerecho()!=null){
            recorridoPreorden(nodo.getHijoDerecho());
        }
    }
    public void recorridoPostorden(NodoarbolBinario<T> nodo){
        if (nodo.getHijoIzquierdo()!=null){
            recorridoPreorden(nodo.getHijoIzquierdo());

        }

        if (nodo.getHijoDerecho()!=null){
            recorridoPreorden(nodo.getHijoDerecho());
        }
        System.out.println(nodo.getElemento().toString());
    }
    //altura y profundidad
    public int altura(NodoarbolBinario<T> nodo){
        int alto=0;
        if (esnodoInterno(nodo)){
            if (nodo.getHijoIzquierdo()!=null){
                alto=Math.max(alto,altura(nodo.getHijoIzquierdo()));

            }
            if (nodo.getHijoDerecho()!=null){
                alto=Math.max(alto,altura(nodo.getHijoDerecho()));
            }
            alto++;
        }
        return alto;

    }
    public int profundidad(NodoarbolBinario<T> nodo){
        int profundo=0;
        if (nodo!=getRaiz()){
            profundo=1+profundidad(nodo.getPadre());
        }
        return profundo;
    }
    //eliminar nodos//





}
