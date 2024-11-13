public class Baul {
    private Character caracter=null;

    public void añadir(Character nuevo) {
        if (caracter!=null){
            throw(new NullPointerException("El baul esta lleno"));
        }
        else {
            this.caracter = nuevo;
        }
    }
    public Character extraer(){
        if (caracter==null){
            throw(new NullPointerException("El baul esta vacio"));
        }
        else{
            Character aux = this.caracter;
            this.caracter = null;
            return aux;
        }
    }
}
