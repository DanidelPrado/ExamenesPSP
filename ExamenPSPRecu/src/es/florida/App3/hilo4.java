package es.florida.App3;

public class hilo4 implements Runnable{
    @Override
    public void run() {
        for(int i =15;i<20;i++){
            System.out.println("Hilo 4 # " + Main.c1.get(i));
        }
    }
}
