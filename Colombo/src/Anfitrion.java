import java.util.ArrayList;
import java.util.Arrays;

public class Anfitrion implements Runnable {
    private Caja caja;
    private ArrayList<Regalos> regalos = new ArrayList<>(Arrays.asList(Regalos.values()));
    private int cont=0;
    private String nombre;

    public Anfitrion(Caja caja,String nombre) {
        this.caja = caja;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for(Regalos regalo : regalos){
            synchronized (caja){
                if (caja.estaVacia() && cont<regalos.size()) {
                    caja.meterRegalo(nombre,new Regalo(regalos.get(cont++)));
                    caja.notifyAll();
                }else{
                    while (!caja.estaVacia()) {
                        try {
                            caja.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
