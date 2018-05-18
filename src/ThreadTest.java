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
    
    // not needed but can be used
    public ThreadTest(){
        // nothing
    }

    /**
     * Main method of thread which starts when this.start() is called,
     * must be implemented as part of Runnable.
     */
    @Override
    public void run(){
        int i = 0;
        while(true){
            System.out.println("Hello");
            if(i%3 == 1){
                this.interrupt();
            }
            i++;
        }
    }
    
    /**
     * Professor does not want this to be used to manage threads
     * synchronized blocks other threads until the method fully executes,
     * otherwise when multiple threads are running values this method may 
     * use could be modified by another thread
     */
    public synchronized void interrupt(){
        System.out.println("ZA WARRUDO!!!");
    }
}
