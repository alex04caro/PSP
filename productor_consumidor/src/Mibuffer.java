import java.util.Arrays;

public class Mibuffer {
    private int[]array;
    private int posLectura=0;
    private int posEscritura=0;


    public Mibuffer(int size) {
        this.array= new int[size];
    }

    public void añadir(int n){
        if(posEscritura>=array.length){
            posEscritura=0;
        }
        array[posEscritura++]=n;
        System.out.println(Arrays.toString(array));
    }

    public int extraer(){
        if(posLectura>=array.length){
            posLectura=0;
        }
        int aux=array[posLectura];
        array[posLectura++]=0;
        System.out.println(Arrays.toString(array));
        return aux;
    }

    public boolean estaLleno(){
        for (int i: array){
            if (i==0){
                return false;
            }
        }
        return true;
    }

    public boolean estaVacio(){
        for (int i: array){
            if (i!=0){
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {

        return "Mibuffer{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
