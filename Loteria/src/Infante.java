import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class Infante implements Runnable{
    private String nombre;
    private Bombo bombo;
    private Combinacion combinacion;

    public Infante(String nombre,Bombo bombo,Combinacion combinacion) {
        this.nombre = nombre;
        this.bombo = bombo;
        this.combinacion = combinacion;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SSS");
    @Override
    public void run() {
        System.out.printf("[%s] Silbando...\n", nombre);
        try {
            Thread.sleep((int)(Math.random()*3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (bombo) {
            bombo.girar();
            Bola bola=bombo.extraerBola();
            Bola copia=new Bola(bola.getNumero());
            bombo.insertarBola(bola);
            System.out.printf("[%S][%S] Ha sacado la bola %d\n", LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).format(formatter), nombre, bola.getNumero());
            try {
                Thread.sleep((int)(Math.random()*5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (combinacion) {
                combinacion.añadirBola(copia);
                System.out.printf("Combinacion= %s\n", combinacion.ToString());
            }
        }
    }
}
