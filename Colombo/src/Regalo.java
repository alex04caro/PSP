public class Regalo {

    private Regalos tipo;

    @Override
    public String toString() {
        return tipo.toString();
    }

    public Regalos getTipo() {
        return tipo;
    }

    public Regalo(Regalos tipo) {
        this.tipo = tipo;
    }
}
