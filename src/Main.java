/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michaelmissana
 */
public class Main {
    
    ThreadTest t;
    RunnableTest r;
    
    public Main(){
        t = new ThreadTest();
        t.start(); // starts thread which runs parallel to other threads
        
    }
    
    
    public static void main(String args[]){
        Main c = new Main();
        // do not do this, it causes only that single thread to run
        // r.run();
        // starts thread which runs parallel to other threads using run method
        (new Thread(new RunnableTest())).start();
    }
    
}
