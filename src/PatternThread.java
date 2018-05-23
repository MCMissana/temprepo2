/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author E
 */
public class PatternThread implements Runnable {

    private int threadNum;
    
    public PatternThread(int termValue) {
        threadNum = termValue;
    }

    // method executed when (new Thread(this)).start() is executed
    // this would be the class name elsewhere
    public void run() {
        // code to be executed by thread
        
        // thread ends
    }

    private double term() {
        return (Math.pow(-1, threadNum)) / (2 * threadNum + 1);
    }

    public double total(int threadNum) {
        double num = 0;
        for (int i = 0; i <= threadNum; i++) {
            num += (Math.pow(-1, i)) / (2 * i + 1);
        }
        return num;
    }
}
