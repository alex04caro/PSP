import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Invitado implements Runnable {
    private Caja caja;
    private ArrayList<Regalo> regalos;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public Regalo getRegalos() {
        try {
            return regalos.get(0);
        }
        catch (Exception e) {
            return null;
        }
    }

    public Invitado(Caja caja, String nombre) {
        this.caja = caja;
        this.nombre = nombre;
        this.regalos = new ArrayList<Regalo>();
    }

    @Override
    public void run() {
        Instant inicio = Instant.now();
        synchronized (caja) {
            while (caja.estaVacia()){
                try {
                    caja.wait(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            regalos.add(caja.sacarRegalo(nombre));
            caja.notifyAll();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant fin = Instant.now();
        System.out.printf("Hilo %s terminado, duración= %d\n", nombre, Duration.between(inicio, fin).toSeconds());
    }
}
