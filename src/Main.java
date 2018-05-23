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
    //RunnableTest r;
    
    public Main(){
        
        for(int i=0; i < 100; i++) {
            t = new ThreadTest(i);
            t.start(); // starts thread which runs parallel to other threads
            
        }
        System.out.println(t.calc());
        double esta =0;
        doAction();
        esta += t.calc();    
        System.out.println(esta);
    }
    private void doAction() {
        calculate( (int)(Math.random() * 4 + 36) );
    }
    private static long calculate(int n) {
        if (n <= 1) return n;
        else return calculate(n-1) + calculate(n-2);
    }
    
    
    public static void main(String args[]){
        Main c = new Main();
        // do not do this, it causes only that single thread to run
        // r.run();
        // starts thread which runs parallel to other threads using run method
       // (new Thread(new RunnableTest())).start();
    }
    
}
