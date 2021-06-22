package es.florida;

import java.io.IOException;
import java.net.Socket;
// PowerShell, java -jar archivo
public class DronController {

    static final int port = 9876;

    public Socket connect() throws IOException {

        return new Socket("localhost",port);
    }

    public void takeOff() throws IOException, InterruptedException {
        System.out.println("Taking off...");
        App.EnviarComandos("TAKE-OFF",true,true);
    }

    public void land() throws IOException, InterruptedException {
        System.out.println("Landing");
        App.EnviarComandos("LAND",true, true);
    }

    public void firePrimaryCannon() throws IOException, InterruptedException {
        System.out.println("Ratatatatatatata!");
        App.EnviarComandos("FIRE_P_W",true,true);
    }

    public void fireSecondaryWeapon() throws IOException, InterruptedException {
        System.out.println("Piñau! Piñau!");
        App.EnviarComandos("FIRE_S_W",true,false);
    }

    public void shutDown() throws IOException, InterruptedException {
        System.out.println("Shutting down system...");
        App.EnviarComandos("OFF",true,false);
    }

}
