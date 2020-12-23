package genericos;
/**Este es un ejemplo de como se utilizan los genericos en java**/

public class Gen_Example_1 <T> {
    /** "T"  Es el parametro de tipo generico **/
    T objeto; // se declara un objeto de tipo T

    Gen_Example_1(T ob){ //Pase al constructor una referencia a un objeto de tipo T
        objeto=ob;
    }
    T getObjeto(){
        return objeto;
    }
    /**Mostrar el objeto de tipo T**/

    void mostrarTipo(){
        System.out.println("El tipo de T es :" + objeto.getClass().getName());
    }
    /**
     Acá creo una demostracion de la clase generica
     lo hice en el mismo fichero por comodidad pero podria
     crearse una clase aparte para así tener mas orden, lo correcto
     sería hacer eso.
     **/
    static class Genericos{
        public static void main(String[] args) {
            //creo una referencia Genericos para integers

            Gen_Example_1<Integer> iObj;
            //cree un Con el nombre Gen_Example_1<Integer> y asigne su referencia a la variable iObj.
            //observe ahorael uso de autoboxing para encapslar el valor de 28 dentro de un objeto integer
            iObj= new Gen_Example_1<Integer>(28);

            //Llamo al metodo de la clase de arriba que lo que hará es mostrar el tipo de dato que estamos usando
            iObj.mostrarTipo();

            int valor=iObj.getObjeto();
            System.out.println("Valor:" + valor);
            System.out.println("");
            System.out.println("");

            System.out.println("-----Objeto generico pero con String ----");
            //acá creo un objeto Generico pero para Strings.
            Gen_Example_1<String> strObjeto= new Gen_Example_1<String>("Este es un generico de tipo String");

            //muestra el objeto string//

            strObjeto.mostrarTipo();
            //obtener el valor del objeto string//
            strObjeto.mostrarTipo();

            // de nuevo noté, que no se necesita conversion//
            String str= strObjeto.getObjeto();
            System.out.println("Valor"+ str);







        }
    }























}
