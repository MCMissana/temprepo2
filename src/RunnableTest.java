/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michaelmissana
 */
public class RunnableTest implements Runnable{
    
    // not needed but can be used
    public RunnableTest(){
        // do not do this
    }
    
    /**
     * Main method of thread which starts when this.start() is called,
     * must be implemented as part of Runnable.
     */
    public void run(){
        int i = 0;
        while(true){
            System.out.println("My name is DIO!");
            i++;
        }
    }
}
