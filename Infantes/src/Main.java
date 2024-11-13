public class Main {
    public static void main(String[] args) {
        Juguete arco = new Juguete();
        Juguete flecha = new Juguete();

        Infante infante1 = new Infante("Infante1",arco,flecha);
        Infante infante2 = new Infante("Infante2",arco,flecha);
        infante1.start();
        infante2.start();

    }
}