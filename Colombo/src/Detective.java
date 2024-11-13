import java.util.ArrayList;
import java.util.Random;

public class Detective implements Runnable {
    private ArrayList<Invitado>invitados;
    public Detective(ArrayList<Invitado>invitados) {
        this.invitados = invitados;
    }

    @Override
    public void run() {
        while(true) {
            Invitado invitado=invitados.get((int)(Math.random()* invitados.size()));
            System.out.printf("Detective pregunta a %s si tiene la pistola\n", invitado.getNombre());
            if(invitado.getRegalos()!=null && invitado.getRegalos().getTipo()==Regalos.PISTOLA){
                System.out.printf("%s ha matado al sr.lemon con la pistola",invitado.getNombre());
                break;
            }else{
                try {
                    Thread.sleep((int) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
