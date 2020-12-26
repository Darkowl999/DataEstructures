package pilas;
import java.util.Stack;
/**
 * Implementacion de pilas a traves de la libreria Stack
 * **/
public class Pilas {
    /**
     * Operaciones basicas que podemos hacer con pilas:
     * PUSH: Añadir un elemento
     * POP: es para sacar un elemento
     * PEEK: revisa el tope o el elemento final de la pila
     * EMPTY: Es para saber si la pila está o no vacia (es un boolean)
     * ***/

    public static void main(String[] args) {
        Stack pila = new Stack();
        pila.push("Mundo");
        pila.push("hola");
        pila.push("jajajaj");
        System.out.println(pila);
        System.out.println(pila.peek());
        pila.pop();
        System.out.println(pila);
        System.out.println(pila.peek());

    }

}





