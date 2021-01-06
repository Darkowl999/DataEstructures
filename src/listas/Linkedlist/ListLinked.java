package listas.Linkedlist;
import java.util.LinkedList;
public class ListLinked {
    public static void main(String[] args) {
        LinkedList lista1= new LinkedList();
        lista1.add("objeto 1");
        lista1.add("objeto 2");
        lista1.add("objeto 3");
        lista1.add("objeto 4");
        lista1.add("objeto 5");
        lista1.add("objeto 6");
        System.out.println(lista1);
        lista1.remove();
        System.out.println(lista1);
        System.out.println("Tamaño de la lista");
        System.out.println(lista1.size());
    }
}
