package es.florida.App2;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class App2_2 {
    public static void main(String[] args) throws IOException {
        String ruta = System.getProperty("user.dir")+"\\out\\production\\ExamenPSPRecu\\es\\florida";
        ProcessBuilder builder = new ProcessBuilder("java", "-cp", ruta, "App2.App2_1",args[0]);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p1 = builder.start();

    }
}
