package arboles;

public class Main {
    public static void main(String[] args) {
       ArbolBinarioBusqueda arbol= new ArbolBinarioBusqueda();
       arbol.insertar(5,"perro");
       arbol.insertar(2,"gato");
       arbol.insertar(1,"loro");
       arbol.insertar(3,"conejo");
       arbol.insertar(8,"pez");
       arbol.insertar(6,"hamster");
       arbol.insertar(10,"iguana");
       arbol.recorridoenOrden(arbol.raiz);
    }
}
