import java.util.ArrayList;

public class Productor extends Thread {
    public Productor(String nombre, Mibuffer buffer, ArrayList<Thread>Consumidores) {
        super(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 12; i++) {
                //while (true){
                    synchronized (buffer) {
                        while(buffer.estaLleno()){
                            try {
                                buffer.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if(buffer.estaVacio()){
                            buffer.añadir(1);
                            buffer.notifyAll();
                        } else{
                            buffer.añadir(1);
                        }
                    }
                }
            }
        });
    }
}