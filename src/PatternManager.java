/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author E
 */
public class PatternManager {

    public static final int limit = 1000;
    private static PatternManager manager;

    boolean[] locks;
    double[] terms;
    double esta = 0; // total

    private PatternManager() {
        for (int i = 0; i < limit; i++) {
            locks = new boolean[limit];
            terms = new double[limit];
        }
    }

    public static PatternManager getInstance() {
        if (manager == null) {
            manager = new PatternManager();
        }
        return manager;
    }

    public void add(double termVal) {
        esta += termVal;
    }

    public double result() {
        return esta;
    }

    public void lock(int threadNum) {
        locks[threadNum] = true;
    }

    public void unlock(int threadNum) {
        locks[threadNum] = false;
    }

    public boolean isLock(int threadNum) {
        return locks[threadNum] == true;
    }

    public boolean isUnlock(int threadNum) {
        return locks[threadNum] == false;
    }

}
