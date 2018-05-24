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

    public static void main(String args[]) {
        PatternThread[] threadArr = new PatternThread[PatternManager.limit];

        // populate terms with 0 and create each thread without starting them
        for (int i = 0; i < PatternManager.limit; i++) {
            threadArr[i] = new PatternThread(i);
        }
        // start each thread
        for (int i = 0; i < PatternManager.limit; i++) {
            threadArr[i].start(); // starts thread which runs parallel to other threads
        }
    }
}
