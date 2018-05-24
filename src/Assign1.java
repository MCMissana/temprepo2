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
    
    // methods
    
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
            
            c.doAction();
            c.enterCriticalRegion(i);
            
            c.leaveCriticalRegion(i);
            c.doAction();
        }
        System.out.println("Estamate: " + c.esta);
        System.exit(0);
    }
    
    public void enterCriticalRegion(int threadNum) {

        //do action method
        while ( locks[threadNum] == true);
        locks[threadNum] = true;
        //does not account for pos 0
        locks[threadNum - 1] = true;
        esta += threadArr[threadNum].term();
        //leave crtical region call


        /*
        int prev;
        prev = threadNum - 1;
        if(threadNum == 0){
            prev = limit - 1 ;
        }
        locks[threadNum]  = true;
        turn = threadNum;
        while ( turn == threadNum && locks[prev] == true);
        esta += threadArr[threadNum].term();
        */
    }
    public void leaveCriticalRegion(int threadNum) {
        locks[threadNum] = false;
        //does not account for pos 0
        locks[threadNum - 1] = true;
    }
}
