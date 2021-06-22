package es.florida.App3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String>  c1=new ArrayList<String>();

    public static void main(String[] args) throws IOException {


        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;

        try {

            String ruta = System.getProperty("user.dir") + "\\src\\es\\florida\\origen.txt";
            File f = new File(ruta);
            entrada = new Scanner(f);

            while (entrada.hasNext()) {
                linea = entrada.nextLine();

                c1.add(linea);

                numeroDeLinea++;

            }


        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
        Runnable t1 = new hilo1();
        Thread tt1 = new Thread(t1);
        tt1.start();
        Runnable t2 = new hilo2();
        Thread tt2 = new Thread(t2);
        tt2.start();
        Runnable t3 = new hilo3();
        Thread tt3 = new Thread(t3);
        tt3.start();
        Runnable t4 = new hilo4();
        Thread tt4 = new Thread(t4);
        tt4.start();

    }}
