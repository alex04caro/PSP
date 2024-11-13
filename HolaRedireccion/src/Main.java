import java.io.*;

public class Main {
    public static void main(String[] args) {
        ProcessBuilder processBuilder= new ProcessBuilder("java","HolaRedireccion");
        processBuilder.directory(new File("E:\\DA2D1A\\PSP\\HolaRedireccion\\out\\production\\HolaRedireccion"));
        try {
            Process process= processBuilder.start();
            //Salida estandar
            BufferedReader estandar = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("Salida estandar");
            String line;
            while((line=estandar.readLine())!=null){
                System.out.println(line);
            }
            //Salida errores
            BufferedReader errores = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("\nSalida errores");
            while((line=errores.readLine())!=null){
                System.err.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}