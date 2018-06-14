import java.io.*;
/**
 *
 * @author Ethan Palser, Mathew Erwin, Michael Missana
 */
public class PatternManager {

    public static int limit;
    private static PatternManager manager;
    private BufferedWriter writer;
    private BufferedWriter writerResult;
    
    File result;
    File log;
    boolean[] locks; // tracks lock state of threads to limit critical region access.
    double[] terms; // contains term of thread
    double esta = 0; // total
    int count; // increments when thread adds term

    private PatternManager(int threadCount, File file) {
        // instantiate arrays and count
        result = new File("/Users/michaelmissana/desktop/output.txt");
        log = file;
        try{
            FileOutputStream output = new FileOutputStream(log);
            writer = new BufferedWriter(new OutputStreamWriter(output));
            
            FileOutputStream output2 = new FileOutputStream(result);
            writerResult = new BufferedWriter(new OutputStreamWriter(output2));

        }catch(IOException ex){
            //nothing, need to be careful if cannot be found
        }
        
        limit = threadCount;
        locks = new boolean[limit]; // default value is false
        terms = new double[limit]; // default value is 0
        count = 0;
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
            // manager = new PatternManager(limit, file); // may not be allowed to work
        }
        return manager;
    }
    
    /**
     * With the constructor private this will return this object and
     * will ensure that there will only ever be one instance of
     * PatternManager, if this class has not been instantiated it will
     * be when this method is called.&nbspThis has been altered to act
     * like the constructor of the class without allowing multiple
     * instances of the manager to exist.
     * 
     * @return This
     */
    public static PatternManager setInstance(int threadCount, File logfile){
        if (manager == null) {
            manager = new PatternManager(threadCount, logfile);
        }
        limit = threadCount;
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
    }

    /**
     * This method returns the current value of estimate for PI/4.
     * 
     * @return 
     */
    public double result() {
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
    public void reset(){
        locks = new boolean[limit]; // default value is false
        terms = new double[limit]; // default value is 0
        count =0;
        esta=0;
    }
        
    /**
     * output method for result
     */
    public void printResult(){
        try{
            
            writerResult.write("Thread Count: " + limit +" | " + this.result()+'\n');
        }catch(IOException ex){
            //nothing, need to be careful if cannot be found
        }
        
    }
    
    public void close(){
        try{
            writerResult.close();
            writer.close();
        }catch(IOException ex){
            //nothing, need to be careful if cannot be found
        }
    }
    
    /**
     * output method for log
     */
    public void printLog(double threadVal){
        try{
            
            writer.write("Thread Count: " + limit +" | current esta: " + this.result()+
            " | current thread value: "+ threadVal + '\n');
        }catch(IOException ex){
            //nothing, need to be careful if cannot be found
        }
        
    }
    
}
