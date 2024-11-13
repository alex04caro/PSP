public class Infante extends Thread{
    private Juguete arco;
    private Juguete flecha;

    public Infante(String nombre,Juguete arco,Juguete flecha) {
        super(nombre);
        this.arco=arco;
        this.flecha=flecha;

    }
    public void run() {

        if(this.getName().equals("Infante1")) {
            synchronized (arco){
                System.out.printf("El %s ha conseguido el arco%n", this.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.printf("El %s intentara conseguir la flecha%n", this.getName());
                synchronized (flecha){
                    System.out.printf("El %s ha conseguido la flecha%n", this.getName());
                }
            }
        }
        else if(this.getName().equals("Infante2")) {
            synchronized (flecha){
                System.out.printf("El %s ha conseguido la flecha%n", this.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.printf("El %s intentara conseguir el arco%n", this.getName());
                synchronized (arco){
                    System.out.printf("El %s ha conseguido el arco%n", this.getName());
                }
            }
        }

    }
}
