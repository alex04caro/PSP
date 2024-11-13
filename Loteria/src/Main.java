import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        //Genereamos el bombo
        Bombo bombo=new Bombo();
        //Generamos las bolas del 0 al 9 y las añadimos al bombo
        for (int i = 0; i < 10; i++) {
            try {
                bombo.insertarBola(new Bola(i));
            }catch (IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }

        }
        //Generamos los infantes y los añadimos a una pool de ExecutorService
        Fabrica fabrica=new Fabrica(bombo,new Combinacion());
        ExecutorService executorService=fabrica.crearInfantes();
    }
}