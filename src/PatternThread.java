/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class extends PatternThread to be an object which can run as its own
 * thread,&nbsp however, using extends prevents the object from subclassing
 * another object&nbsp restricting its usage.
 *
 * @author michaelmissana
 */
public class PatternThread extends Thread {

    public int threadNum;
    public double aprox;
    public boolean interested; // locally stored check for locking other threads, may not use

    public PatternThread(int termNum) {
        threadNum = termNum;
    }

    /**
     * Main method of thread which starts when this.start() is called, must be
     * implemented as part of Runnable.
     */
    public void run() {
        while(aprox == 0){
            // wait until term() is called and calculated
        }
    }

    // this method calculates a term in the Gregory-Leibniz Series
    // only executed when it is interested and allowed to execute
    public double term() {
        return aprox = (Math.pow(-1, threadNum)) / (2 * threadNum + 1);
    }
    
    public void doAction() {
        calculate((int) (Math.random() * 4 + 36));
    }

    private static long calculate(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }
}
