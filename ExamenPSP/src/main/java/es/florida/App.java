package es.florida;

import org.jasypt.util.text.StrongTextEncryptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static Socket socket;
    public static final int server = 6789;
    private static final int threads = 2;
    private static final String password = "1234";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Ejercicio 2
        DronController controller = new DronController();
        socket = controller.connect();
        controller.takeOff();
        controller.land();
        controller.firePrimaryCannon();
        controller.fireSecondaryWeapon();
        controller.shutDown();

        socket.close();

        // Ejercicio 3
        /*ExecutorService executorService = Executors.newFixedThreadPool(threads);
        ServerSocket serverSocket = new ServerSocket(server);
        Socket client;
        while (true){
            client = serverSocket.accept();
            System.out.println("Cliente conectado al puerto " + client.getPort());
            executorService.execute(new ENEMY_SPOTTED(client));
        }*/


    }
    // Ejercicio 3
    /*private static class ENEMY_SPOTTED implements Runnable {
        Socket connection;
        public ENEMY_SPOTTED(Socket client) {
            this.connection = client;
        }

        @Override
        public void run() {
            System.out.println("El comando ha llegado");
            System.out.println("Dron activo " + Thread.currentThread().getName());
        }
    }*/
    // Ejercicio 2
    public static void EnviarComandos(String command,boolean wait,boolean encrypt) throws IOException, InterruptedException{
        OutputStream output = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(output));
        if(encrypt){
            command = Encriptar(command);
        }
        printer.println(command);
        printer.flush();
        if(wait){
            Thread.sleep(1000);
        }
    }

    //Ejercicio 5
    private static String Encriptar(String key){
        StrongTextEncryptor encryptor = new StrongTextEncryptor();
        encryptor.setPassword(password);
        return encryptor.encrypt(key);
    }
}
