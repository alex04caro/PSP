import java.io.*;

public class LanzadorLectorPeso {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java","LectorPeso");
        pb.directory(new File("E:\\DA2D1A\\PSP\\Peso\\out\\production\\Peso"));
        pb.redirectErrorStream(true);
        try {
            Process process= pb.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            bw.write("70\n");
            bw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
