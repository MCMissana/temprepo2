/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.Math;
    
/**
 *
 * @author Mathew
 */
public class pattern {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new pattern().start();
        System.exit(0);
    }
    public void start() {
        System.out.println(total(0));
        System.out.println(total(1));
        System.out.println(total(2));
        System.out.println(total(3));
    }
    
    public double total(int threadNum) {
        double num = 0;
        for (int i=0; i <= threadNum; i++) { 
            num += (Math.pow(-1,i))/(2*i+1);
        }
        return num;
    }
    
}
