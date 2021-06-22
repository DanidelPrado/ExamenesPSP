package es.florida.App3;

public class hilo1 implements Runnable{
    @Override
    public void run() {

        for(int i =0;i<5;i++){
            System.out.println("Hilo 1 # " + Main.c1.get(i));
        }
    }



}

