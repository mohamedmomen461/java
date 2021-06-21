/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author smc
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleThread s1=new SimpleThread("Thread object 1");
        s1.start();
        SimpleThread s2=new SimpleThread("Thread object 2");
        s2.start();
        Thread s3=new Thread(new SimpleRunThread("Runnable object") );
        s3.start();
    }
    
}
