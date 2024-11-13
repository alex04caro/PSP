import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
    ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","dir","/w","/p");
    processBuilder.directory(new File(System.getProperty("user.home")));
    processBuilder.redirectError(new File("error.log"));
        try {
            Process process= processBuilder.start();
            BufferedReader buffer=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line=buffer.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
