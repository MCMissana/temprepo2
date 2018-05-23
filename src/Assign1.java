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

        PatternThread[] threadArr = new PatternThread[c.limit];
        PatternThread t; // individual thread, does nothing

        double esta = 0;
        for (int i = 0; i < 100; i++) {
            threadArr[i] = new PatternThread(i);
            threadArr[i].start(); // starts thread which runs parallel to other threads

            c.doAction();
            System.out.println(threadArr[i].calc());
            esta += threadArr[i].calc();
        }

        System.out.println("Estamate: " + esta);
    }

}
