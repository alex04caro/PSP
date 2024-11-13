public class Caja {
    private Regalo[] contenido = new Regalo[1];

    public boolean estaVacia(){
        if(contenido[0] == null){
            return true;
        }
        return false;
    }

    public Regalo sacarRegalo(String nombreHilo) {
        Regalo aux = contenido[0];
        contenido[0] = null;
        System.out.printf("El hilo %s a extraido un/a %s de la caja\n",nombreHilo,aux.toString());
        return aux;
    }

    public void meterRegalo(String nombreHilo,Regalo regalo) {
        this.contenido[0] = regalo;
        System.out.printf("El hilo %s a añadido un/a %s a la caja\n",nombreHilo,regalo.toString());
    }
}
