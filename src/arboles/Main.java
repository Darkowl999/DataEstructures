package arboles;

public class Main {
    public static void main(String[] args) {
       Nodo nodo=new Nodo(0);
       ArbolBinario arbol= new ArbolBinario();
      arbol.insertarNodo(1,"Abuelo");
       arbol.insertarNodo(2,"Hermano1");
       arbol.insertarNodo(3,"Hermano2");
       arbol.insertarNodo(4,"Hijo1");
       arbol.insertarNodo(5,"Hijo2");
       System.out.println("---RECORRIDOS---");
       arbol.recorridoenOrden(arbol.raiz);
        System.out.println("Recorrido antes de la eliminación");
        System.out.println("-----------------------------------");





    }
}
