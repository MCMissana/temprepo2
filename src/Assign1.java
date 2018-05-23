/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michaelmissana
 */
public class Assign1 {

    private static int limit = 100000000; // 100,000,000

    public static void main(String args[]) {
        PatternManager consumer = new PatternManager();
        PatternThread[] threadArr = new PatternThread[limit];
        
        boolean[] locks = new boolean[limit];
        double[] terms = new double[limit];
        double esta = 0; // total

        // populate terms with 0 and create each thread without starting them
        for (int i = 0; i < 100; i++) {
            threadArr[i] = new PatternThread(i);
            terms[i] = 0.0;
        }
        // start each thread
        for (int i = 0; i < 100; i++) {
            threadArr[i].start(); // starts thread which runs parallel to other threads
        }

        while(true){
            c.doAction();
            // lock thread(s)

            // critical region  
            terms[i] = threadArr[i].term();
            esta += terms[i];
            // critical region end

            // unlock thread(s)
            c.doAction();
        }
        
        System.out.println("Estamate: " + esta);
    }

}
