package es.florida.App3;

public class hilo2 implements Runnable{
    @Override
    public void run() {
        for(int i =5;i<10;i++){
            System.out.println("Hilo 2 # " + Main.c1.get(i));
        }
    }
}
