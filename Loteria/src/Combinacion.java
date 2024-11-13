import java.util.ArrayList;

public class Combinacion {
    private static ArrayList<Bola>combinacion=new ArrayList<>();

    public Combinacion() {

    }

    public void añadirBola(Bola bola) {
        combinacion.add(bola);
    }
    public String ToString(){
        String resultado = "";
        for (Bola bola : combinacion) {
            resultado += String.valueOf(bola.getNumero());
        }
        return resultado;
    }
}
