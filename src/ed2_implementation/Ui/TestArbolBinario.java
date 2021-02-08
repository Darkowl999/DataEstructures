package ed2_implementation.Ui;

import ed2_implementation.ArbolBinarioBusqueda;
import ed2_implementation.IArbolBusqueda;

public class TestArbolBinario {
    public static void main(String[] args) {
        IArbolBusqueda<Integer,String> arbolPrueba= new ArbolBinarioBusqueda<>();
        arbolPrueba.insertar(50,"Azul");
        arbolPrueba.insertar(78,"Naranja");
        arbolPrueba.insertar(74,"Zapato");
        arbolPrueba.insertar(30,"Jeans");
        arbolPrueba.insertar(44,"Amarillo");
        arbolPrueba.insertar(20,"Negro");
        arbolPrueba.insertar(25,"Café");
        arbolPrueba.insertar(24,"Camisa");
        arbolPrueba.insertar(23,"Mesa");
        arbolPrueba.insertar(28,"TV");
        System.out.println("Recorrido en PostOrden"+ arbolPrueba.recorridoEnPostOrden());
        System.out.println("Recorrido en Inorden"+ arbolPrueba.recorridoEnInOrden());
        System.out.println("ALTURA DE LOS ARBOLES");
        System.out.println("Altura del Arbol"+ arbolPrueba.altura());
        System.out.println("Altura del Arbol"+ ((ArbolBinarioBusqueda<Integer, String>) arbolPrueba).alturaI());
        System.out.println("minimo"+arbolPrueba.minimo());
    }
}
