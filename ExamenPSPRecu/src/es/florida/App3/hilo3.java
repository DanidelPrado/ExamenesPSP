package es.florida.App3;

public class hilo3 implements Runnable{
    @Override
    public void run() {
        for(int i =10;i<15;i++){
            System.out.println("Hilo 3 # " + Main.c1.get(i));
        }
    }
}

