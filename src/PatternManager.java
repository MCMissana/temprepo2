import java.io.*;
/**
 *
 * @author Ethan Palser, Mathew Erwin, Michael Missana
 */
public class PatternManager {

    public static int limit;
    private static PatternManager manager;

    boolean[] locks; // tracks lock state of threads to limit critical region access.
    double[] terms; // contains term of thread
    double esta = 0; // total
    int count; // increments when thread adds term
    public static PrintWriter log;
    public static PrintWriter finalOutput;

    private PatternManager(int threadCount) {
        // instantiate arrays and count
        limit = threadCount;
        locks = new boolean[limit]; // default value is false
        terms = new double[limit]; // default value is 0
        count = 0;

        //outputs for log and final values
        try {
        PrintWriter log = new PrintWriter("H:\\log.txt","UTF-8");
        PrintWriter finalOutput = new PrintWriter("H:\\final.txt","UTF-8");
        } catch(Exception exc) {
        }
    }

    /**
     * With the constructor private this will return this object and
     * will ensure that there will only ever be one instance of
     * PatternManager, if this class has not been instantiated it will
     * be when this method is called.
     * 
     * @return This
     */
    public static PatternManager getInstance() {
        if (manager == null) {
            // manager = new PatternManager(); // may not be allowed to work
        }
        return manager;
    }
    
    /**
     * With the constructor private this will return this object and
     * will ensure that there will only ever be one instance of
     * PatternManager, if this class has not been instantiated it will
     * be when this method is called.
     * 
     * @return This
     */
    public static PatternManager getInstance(int threadCount) {
        log.println("New Batch using Parameters: "+ threadCount);
        finalOutput.print("New Batch using Parameters: "+ threadCount+". Gives final value of ");

        if (manager == null) {
            // if already created for thread
            manager = new PatternManager(threadCount);
        }
        return manager;
    }

    /**
     * This method adds the termValue to the total estimate for PI/4,
     * and increments a counter to check when enough terms have been added.
     * 
     * @param termVal 
     */
    public void add(double termVal) {
        esta += termVal;
        count++;
        log.println("term value =" + termVal +" ");
    }

    /**
     * This method returns the current value of estimate for PI/4.
     * 
     * @return 
     */
    public double result() {
        finalOutput.println(esta);
        System.out.println("abs");
        finalOutput.close();
        log.close();
        return esta;  
    }

    /**
     * This method returns the current count for terms added to the
     * estimate.
     * 
     * @return 
     */
    public int count(){
        return count;
    }
    
    /**
     * This method takes the thread number and sets its lock to true,
     * which is used to prevent access into certain (critical) regions
     * of code.
     * 
     * @param threadNum 
     */
    public void lock(int threadNum) {
        locks[threadNum] = true;
    }

    /**
     * This method takes the thread number and sets its lock to false,
     * which is used to prevent access into certain (critical) regions
     * of code, releasing it so it may access the region again or inform
     * other threads it is available.
     * 
     * @param threadNum 
     */
    public void unlock(int threadNum) {
        locks[threadNum] = false;
    }

    /**
     * This method returns the current status of the lock, and is
     * considered locked if true.
     * 
     * @param threadNum
     * @return 
     */
    public boolean isLock(int threadNum) {
        return locks[threadNum] == true;
    }

    /**
     * This method returns the current status of the lock, and is
     * considered unlocked if false.
     * 
     * @param threadNum
     * @return 
     */
    public boolean isUnlock(int threadNum) {
        return locks[threadNum] == false;
    }

    /**
     * This method is used to set the locks all to false
     */
    public void resetLocks(){
        locks = new boolean[locks.length];
    }
    
}
