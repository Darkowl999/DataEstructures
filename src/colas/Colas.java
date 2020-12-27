package colas;
import java.util.LinkedList;
import java.util.Queue;
public class Colas {
    public static void main(String[] args) {
        Queue<String> cola1= new LinkedList<String>();
        System.out.println("Insertamos los siguientes elementos");
        cola1.add("Juan"); //añadimos un elemento o encolamos
        cola1.add("AnaS");
        cola1.add("Luis");
        System.out.println("cantidad de elementos de la cola"+cola1.size());
        System.out.println("Extraemos elementos de la cola"+cola1.poll());
        System.out.println("cantidad de elementos de la cola"+cola1.size());
        System.out.println("primer elemento de la cola"+cola1.peek());
        System.out.println("Extraemos uno a un cada elemento de la cola mientras no este vacía:");

        while (!cola1.isEmpty())
            System.out.print(cola1.poll() + "-");
            System.out.println();
            System.out.println("-----------------------------------");
            //cola 2//
            Queue<Integer> cola2= new LinkedList<Integer>();
            cola2.add(70);
            cola2.add(120);
            cola2.add(6);
            System.out.println("Impresion de la cola de enteros");

        for (Integer elemento:cola2){
            System.out.println(elemento+"-");
            System.out.println();
            System.out.println("borramos toda la cola");
            cola2.clear();
            System.out.println("La cantidad de elementos de la cola"+cola2.size());
        }


    }


}
