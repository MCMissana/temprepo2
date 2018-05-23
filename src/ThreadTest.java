/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class extends Thread to be an object which can run as its own thread,&nbsp
 * however, using extends prevents the object from subclassing another object&nbsp
 * restricting its usage.
 * 
 * @author michaelmissana
 */
public class ThreadTest extends Thread{
    public int i;
    public double aprox;
    // not needed but can be used
    public ThreadTest(int number){
        // nothing
        i  = number;
    }

    /**
     * Main method of thread which starts when this.start() is called,
     * must be implemented as part of Runnable.
     */
    @Override
    public void run(){ 
        this.interrupt();
    }
    
    

    
    public synchronized void interrupt(){
        //PatternThread ptn = new PatternThread();
        //double aprox = ptn.number(i, (Math.pow(-1,i))/(2*i+1)); 
        double aprox = (Math.pow(-1,i))/(2*i+1);
        System.out.println(aprox);
    }
    
    public double calc() {
        return aprox;
    }
}
