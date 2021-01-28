package bst.cruce_arbol_de_orden_de_nivel;

public class Main {
    public static void main(String[] args) {
      /*  BinaryTree arbol= new BinaryTree();
        arbol.root= new Node(1);
        arbol.root.left=new Node(2);
        arbol.root.right= new Node(3);
        arbol.root.left.left= new Node(4);
        arbol.root.right.right= new Node(5);

        System.out.println("El recorrido del orden de nivel del árbol binario es ");
        arbol.printGivenLevel(arbol.root,3);*/
        BinaryTree arbol= new BinaryTree();
        arbol.root=new Node(10);
        arbol.root.left= new Node(11);
        arbol.root.left.left= new Node(7);
        arbol.root.right= new Node(9);
        arbol.root.right.left= new Node(15);
        arbol.root.right.right= new Node(8);
        System.out.println("Recorrido en orden antes de la inserción:");
        arbol.inorden(arbol.root);
        System.out.println("-----------------------------------------");
        System.out.println("Recorrido en orden después de la inserción:");
        int key=12;
        arbol.insertar(arbol.root, key);
        arbol.inorden(arbol.root);



    }
}
