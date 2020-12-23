package pilas;
import java.util.Stack;
public class Pilas {
    public static void main(String[] args) {
        Stack<String> pila1= new Stack<String>();
        System.out.println("EJEMPLO DE COMO SE USA ESTA LIBRERIA");
        System.out.println("Insertando elementos en la pila");
        pila1.push("elemento1");
        pila1.push("elemento2");
        pila1.push("elemento3");
        pila1.push("elemento4");
        pila1.push("elemento5");
        System.out.println("Terminamos de insertar elementos");
        System.out.println("----------------------------------");
        System.out.println(pila1.peek());
        System.out.println("Aca quito al elemento 5");
        pila1.pop();
        System.out.println("Este es el ultimo elemento");
        System.out.println(pila1.peek());
        System.out.println("fin del programa");
    }
    Stack<String> pila2 = new Stack<String>();
    /****/
}





