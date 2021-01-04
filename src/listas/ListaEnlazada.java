package listas;

public class ListaEnlazada {
    Nodo cabeza=null; //es el punto de inicio o partida para nosotros poder recorrer la lista
    int tamanio;

    public ListaEnlazada(){
        cabeza=null;
        tamanio=0;
    }
    public void eliminarPrimero(){//este método elimina el primer elemento de una lista de la siguiente forma
        cabeza=cabeza.obtenerSiguiente();//recorremos la cabeza una posicion, es decir nombramos una nueva cabeza
        tamanio--; //luego reducimos el tamaño de la lista para completar dicha accion
        //el recolector de basura de java  se encargara de eliminar el nodo que quedó sin apuntar a nadie
    }
    public void eliminarIndice(int indice){ //esté metodo se encarga de eliminar nodos por indice
        int contador=0;
        Nodo temporal=cabeza;// se crea un nodo temporal que sera la copia de nuestra cabeza
        if (indice==0){ //sie el indice es igual a cero es decir es la cabeza
            cabeza=cabeza.obtenerSiguiente();//se recorre la cabeza al siguiente nodo
        }else{// si el indice no es cero se hace lo siguiente:
            while (contador<indice-1){ //se hace un bucle de control donde el contador es igual a cero y su limite es el indice que queremos pero una posicion antes
                                       //esto se hace para que podamos apuntar uno antes que el que queremos eliminar al siguiente del indice
                temporal=temporal.obtenerSiguiente();
                contador++;
            }

            temporal.enlazarSiguiente(
                    temporal.obtenerSiguiente().obtenerSiguiente()
            );
        }
       tamanio--;

    }
    public void cortar(int indice){// este metodo es como el de eliminar por indice con la particularidad es que nosotros decidimos hasta donde tomar en cuenta la lista
       //Ejemplo:
        // |1|->|2|->|3|->|4|->|5|->|6|-> ...
        //queremos cortar a partir del indice 2, hace todo el proceso y nuestra lista quedará   de la siguiente manera:
        // |1|->|2|->|3|
        //los demas elementos como ser el 4,5,6 quedaran volando y el recolector de basura los eliminará
        int contador=0;
        Nodo temporal= cabeza;
        while (contador<indice-1){
            temporal=temporal.obtenerSiguiente();
            contador++;
        }
        temporal.enlazarSiguiente(null);
        tamanio=indice;

    }

    public void addPrimero(Object objeto){
        if (cabeza==null){//si la cabeza es null indica que nuestra lista esta vacia por tanto
                          //se añade el nodo tranquilamente
            cabeza= new Nodo(objeto);
        }else{ //en caso de que la lista contenga elementos se hace lo siguiente:
            Nodo temporal=cabeza;//se crea un nodo temporal este será igual a la cabeza actual
            Nodo nuevoNodo= new Nodo(objeto);//Se crea otro nodo que este será el que añadiremos o la nueva cabeza
            nuevoNodo.enlazarSiguiente(temporal);//luego con los metodos hechos en la clase nodo enlazamos el nuevo nodo a nuestra cabeza temporal
            cabeza=nuevoNodo;//luego indicamos que nuestra nueva cabeza de la lista es el nuevo nodo insertado.
        }
        tamanio++;

    }
    public Object obtener(int indice){//con este metodo obtendremos el valor de cierto indice de la lista
        int contador=0;
        Nodo temporal=cabeza;//digamos que creamos una copia de la cabeza para poder mantener la lista sin afectarla directamente
        while (contador<indice){//usamos contador como variable de control del ciclo
            temporal=temporal.obtenerSiguiente();//cada vuelta del ciclo se recorrerá la cabeza para buscar u obtener el valor del index
            contador++; //el contador se incrementa
            //ejemplo: si nuestra lista tiene 5 elementos y nos interesa obtener el valor de la posicion 3
            //el contador inicializara en cero y como cero es menor que el indice que es 3 volvera a iniciar el bucle y el contador aumentara de 1 en 1
            //una vez el contador llegue al valor de 3 se hara una ultima consulta diciendo si el contador=3 es igual al indice=3 como 3 no es menor que 3//
            // osea no cumple la condición sale del ciclo y retorna el valor de esa posicion.
        }
        return temporal.obtenerValor();//Este es el valor que retornará una vez haya recorrido y hecho todo el proceso mencionado arriba.
    }

    public int tamanio(){//Este método su unica funcion es devolver la longitud o cantidad de elementos de la lista por llamarlo así.
        return tamanio;
    }

    public boolean estaVacia(){
        if (cabeza==null){
            return true;
        }else{
            return false;
        }
    }

}
