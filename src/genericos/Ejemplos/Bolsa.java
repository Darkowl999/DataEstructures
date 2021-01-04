package genericos.Ejemplos;

public class Bolsa <N,V>{
    N nombre;
    V valor;
    public Bolsa(N nombre,V valor){

       this.nombre=nombre;
        this.valor=valor;
    }

    public N getNombre() {
        return nombre;
    }

    public void setNombre(N nombre) {
        this.nombre = nombre;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    void mostrarProducto(){
        System.out.println("El nombre es"+""+nombre.getClass().getName());
        System.out.println("El valor es"+""+valor.getClass().getName());
    }

    static class Producto{
        public static void main(String[] args) {
            System.out.println("-----------------------");
            System.out.println("Lista de productos");
            //Creacion de los objetos y su producto como tal:
            Bolsa<String,Integer> producto1= new Bolsa<String,Integer>("Galletas",20);
            Bolsa<String,Integer> producto2= new Bolsa<String,Integer>("Soda",10);
            Bolsa<String,Integer> producto3= new Bolsa<String,Integer>("Leche",20);

            System.out.println(producto1.getNombre()+" ,"+"Precio :"+producto1.getValor() +"Bs");
            System.out.println(producto2.getNombre()+" ,"+"Precio :"+producto2.getValor() +"Bs");
            System.out.println(producto3.getNombre()+" ,"+"Precio :"+producto3.getValor() +"Bs");
            producto1.setNombre("Pilfrut");
            System.out.println(producto1.getNombre()+" ,"+"Precio :"+producto1.getValor() +"Bs");



        }
    }

}
