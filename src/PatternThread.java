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

    public PatternThread(int termValue) {
        threadNum = termValue;
    }

    /**
     * Main method of thread which starts when this.start() is called, must be
     * implemented as part of Runnable.
     */
    public void run() {
        this.term();
    }

    public void term() {
        aprox = (Math.pow(-1, threadNum)) / (2 * threadNum + 1);
    }

    public synchronized double calc() {
        return aprox;
    }
}
