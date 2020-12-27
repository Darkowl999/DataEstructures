package pilas.Amano;

import javax.imageio.stream.ImageInputStream;

/***
 * Implementacion de pilas a mano
 * **/

public class Pila{
    String arr[];
    int tamanioMaximo;
    int tope;

    public Pila(int tamanio){ //Contructor por defecto//
        tamanioMaximo=tamanio;
        arr= new String[tamanioMaximo];
        tope=0;
    }
    public boolean empty(){
        if (tope==0){
            return true;
        }else{
            return false;
        }

    }
    public void push(String cadena){
        if (tope<tamanioMaximo){
            arr[tope]=cadena;
            tope++;
        }

    }
    public String peek(){
        if (tope>0){
            return arr[tope-1];
        }else{
            return null;
        }
    }
    public String pop(){
        String temporal=null; //Esta variable se la toma como auxiliar
        if (tope>0){
            temporal= arr[tope-1];
            arr[tope-1]=null;
            tope--;
        }
        return temporal;








    }





















}
