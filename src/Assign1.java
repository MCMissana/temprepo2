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

    public Assign1() {
    }

    private void enter_region(int termNum) {

    }

    private void doAction() {
        calculate((int) (Math.random() * 4 + 36));
    }

    private static long calculate(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }

    public static void main(String args[]) {
        Assign1 c = new Assign1();
        PatternThread[] threadArr = new PatternThread[limit];
        boolean[] locks = new boolean[limit];
        double[] terms = new double[limit];
        double esta = 0; // total

        // populate terms with 0 and create each thread without starting them
        for (int i = 0; i < c.limit; i++) {
            threadArr[i] = new PatternThread(i);
            terms[i] = 0.0;
        }
        // start each thread
        for (int i = 0; i < c.limit; i++) {
            threadArr[i].start(); // starts thread which runs parallel to other threads

            c.doAction();
            // lock thread(s)
            c.doAction();

            // critical region  
            terms[i] = threadArr[i].term();
            esta += terms[i];
            // critical region end

            c.doAction();
            // unlock thread(s)
            c.doAction();
        }

        System.out.println("Estamate: " + esta);
    }

}
