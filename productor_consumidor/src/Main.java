import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Mibuffer buffer = new Mibuffer(12);
        ArrayList<Thread> Hilos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Hilos.add(new Consumidor("C" + i, buffer));
        }

        Hilos.add(new Productor("P1",buffer,Hilos));

        for(Thread hilo:Hilos){
            hilo.start();
        }
    }
}