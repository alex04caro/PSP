import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LectorPeso {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int peso= Integer.valueOf(br.readLine());
            System.out.printf("peso: %d\n",peso);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
