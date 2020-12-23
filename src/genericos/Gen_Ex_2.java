package genericos;
/**
 *En esta clase se plantea usar los generics de java pero esta vez con 2 parametros
 ***/
public class Gen_Ex_2<T,V> {
    //aca se usa dos parametoros de tipo:
    T objeto1;
    V objeto2;

    //Constructor por referencia o parametro

    Gen_Ex_2(T ob1, V ob2){
        objeto1=ob1;
        objeto2=ob2;
    }
    T getObjeto1(){
        return objeto1;
    }
    V getObjeto2(){
        return objeto2;
    }

    //mostrar el tipo de T y V;
    void mostrarTipo(){
        System.out.println("El tipo de T es "+" "+ objeto1.getClass().getName());
        System.out.println("El tipo de V es "+" "+ objeto2.getClass().getName());
    }
    /** Demostracion de la clase genericos con 2 parametros ***/
    static class GenericosEx_2{
        public static void main(String[] args) {
            Gen_Ex_2<Integer,String> dosGenericos= new Gen_Ex_2<Integer,String>(28,"Generico String");
            //mostrar los tipos
            dosGenericos.mostrarTipo();
            //obtener y mostrar los valores//
            int valor= dosGenericos.getObjeto1();
            System.out.println("Valor"+" "+valor);
            //aca obtendriamos el valor de la cadena como al
            System.out.println("");
            System.out.println("Valor del segundo objeto");
            String valor2= dosGenericos.getObjeto2();
            System.out.println("Valor2"+" "+valor2);

        }


    }








}
