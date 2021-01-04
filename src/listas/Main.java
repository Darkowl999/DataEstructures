package listas;

public class Main {
    public static void main(String[] args) {
        Nodo primero = new Nodo("cadena1");
        Nodo segundo = new Nodo(22);
        Nodo tercer  = new Nodo("hola");
        //enlazar nodos//
        primero.enlazarSiguiente(segundo);
        segundo.enlazarSiguiente(tercer);
        primero.obtenerSiguiente();
        System.out.println(primero.obtenerSiguiente().valor);
        ListaEnlazada nuevalista= new ListaEnlazada();
        nuevalista.addPrimero("primer objeto");


    }

}
