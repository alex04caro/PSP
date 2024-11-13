import java.util.ArrayList;
import java.util.Collections;

public class Bombo {
    ArrayList<Bola>bolas=new ArrayList<>();

    public void insertarBola(Bola bola){
        if(bolas.size()==10){
            throw new IndexOutOfBoundsException("El bombo no puede contener mas de 10 bolas");
        }else {
            bolas.add(bola);
        }
    }
    public Bola extraerBola(){
        if(bolas.isEmpty()){
            throw new IndexOutOfBoundsException("El bombo está vacio");
        }
        else{
            Bola seleccionada=bolas.getLast();
            bolas.remove(seleccionada);
            return seleccionada;
        }
    }
    public void girar(){
        Collections.shuffle(bolas);
    }
}
