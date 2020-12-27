package pilas.Amano;
/**
 * Este main solo se encarga de mostrar los me
 * **/
public class Main {
    public static void main(String[] args) {
        Pila pila= new Pila(3);
        pila.push("Hola");
        pila.push("Mundo");
        System.out.println(pila.pop());
        System.out.println(pila.peek());
    }
}
