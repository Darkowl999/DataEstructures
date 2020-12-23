package pilas;
import java.util.EmptyStackException;
import java.util.Stack;
public class pruebaStack {
    public pruebaStack(){ //ESte constructor se encuentra vacio lo que hace es apilar solamente no tiene o no necesita parametros;
        Stack<Number> pila= new Stack<Number>();
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        imprimirPila(pila);

    }

    //metodo para imprimir la pila como tal//
    public void imprimirPila(Stack<Number> pila){
        if (pila.empty()){ //pregunta si la pila se encuentra vacia
            System.out.println("la pila esta vacia");
        }else{
            System.out.println("La pila contiene");
            for (Number numero: pila){ //hace una especie de recorrido del numero dentro de la pila
                System.out.println(numero);
            }
            System.out.println("(superior)\n\n");
        }

    }

    public static void main(String[] args) {
        new pruebaStack(); //en este main inicializo la clase;
    }
}
