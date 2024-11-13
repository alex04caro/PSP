public class Consumidor extends Thread{
    public Consumidor(String nombre, Mibuffer buffer) {
        super(new Runnable() {
            public void run() {

                for (int i = 0; i < 4; i++) {
                //while (true){
                    synchronized (buffer) {
                        while (buffer.estaVacio()) {
                            try {
                                buffer.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        buffer.extraer();
                        buffer.notifyAll();
                    }
                }

            }
        });
    }
}
