import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fabrica {
    private Bombo bombo;
    private Combinacion combinacion;

    public Fabrica(Bombo bombo,Combinacion combinacion) {
        this.bombo = bombo;
        this.combinacion = combinacion;
    }

    private static ArrayList<String>nombres=new ArrayList<>(Arrays.asList("Amanda","Beatriz","Carlos","Daniela","Eduardo"));
    public ExecutorService crearInfantes() {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Infante(nombres.get(i),bombo,combinacion));
        }
        return executorService;
    }
}
