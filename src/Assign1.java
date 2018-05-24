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

    private static int limit = 10; // 100,000,000
    private static boolean[] locks = new boolean[limit];
    int turn;
    public double esta = 0; // total
    public PatternThread[] threadArr = new PatternThread[limit];
    
    //private void enter_region(int termNum) {
//
   // }

    private void doAction() {
        calculate((int) (Math.random() * 4 + 36));
    }
    
    public boolean locked(int x) {
        return locks[x];
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
        double[] terms = new double[limit];
        
        // populate terms with 0 and create each thread without starting them
        for (int i = 0; i < c.limit; i++) {
            c.threadArr[i] = new PatternThread(i);
            terms[i] = 0.0;
            locks[i] = false;
        }
        // start each thread
        for (int i = 0; i < c.limit; i++) {
            c.threadArr[i].start(); // starts thread which runs parallel to other threads
            c.enterCriticalRegion(i);
        }
        System.out.println("Estamate: " + c.esta);
        System.exit(0);
    }
    
    public void enterCriticalRegion(int threadNum) {
        int num;
        doAction();
        num = limit - threadNum - 1;
        if (num < 0) num = 0;
        locks[threadNum]  = true;
        turn = threadNum;
        while ( turn == threadNum && locks[num] == true);
        esta += threadArr[threadNum].term();
        leaveCriticalRegion(threadNum);
    }
    public void leaveCriticalRegion(int threadNum) {
        doAction();
        locks[threadNum] = false;
    }
}
