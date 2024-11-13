import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Caja caja = new Caja();
        ArrayList<Invitado> lista_invitados =new ArrayList<>();
        ExecutorService anfitrion= Executors.newSingleThreadExecutor();
        ExecutorService invitados= Executors.newFixedThreadPool(6);
        ExecutorService detective= Executors.newSingleThreadExecutor();

        anfitrion.execute(new Anfitrion(caja,"Anfitrion"));
        for (int i = 0; i < 5; i++) {
            lista_invitados.add(new Invitado(caja,("Invitado"+i)));
            invitados.execute(lista_invitados.get(i));
        }
        detective.execute(new Detective(lista_invitados));

    }
}