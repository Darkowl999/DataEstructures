package algoritmos;

public class Numeros_Enteros {

    public static void main(String[] args) {
        System.out.println(contadorImpares(579132));
    }
    public static boolean esPar(int numero){
        return numero%2==0;
    }
    public static boolean noesPar(int numero){
        return !esPar(numero);
    }
    public static int contadorSimple(int numero){
        int contador=0;
        while(numero!=0){
            numero= numero /10;
            contador++;
        }
        return contador;
    }
    public static int contadorS(int numero){//Este es el mismo contador de arriba pero con for
        int contador=0;
        for (int i = 0; i <= numero; i++) {
            if ((numero%10)%2==0){
                contador++;
                numero=numero/10;
            }else{
                numero=numero/10;
            }
        }
        return contador;
    }
    public static int contadorPares(int numero){
        int contador=0;
        while(numero!=0){
            if ( (numero%10)%2==0){
                contador++;
                numero=numero/10;
            }else{
                numero=numero/10;
            }
        }
        return contador;
    }
    public static int contadorImpares(int numero){
        int contador=0;
        while (numero!=0){
            if ((numero%10)%2!=0){
                contador++;
                numero=numero/10;
            }else{
                numero=numero/10;
            }
        }
        return contador;
    }

    /**QUEDA PENDIENTE LOS PALINDROMOS LOS PRIMOS Y OTROS PROBLEMAS QUE SE NOS OCURRAN**/

}
