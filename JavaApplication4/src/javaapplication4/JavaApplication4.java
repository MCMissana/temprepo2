/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import BasicIO.*;

package javaapplication4;
import java.lang.Object.*;
import java.io.*; //InputStream.*;
import java.io.File.*;
/**
 *
 * @author Mathew
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new JavaApplication4().starts();
        System.exit(0);
    }
    
    public void starts() {
        int i; 
        //PrintWriter writer = new PrintWriter("H:\\test.txt","UTF-8");
        try {
            System.setOut(new PrintStream(new FileOutputStream("H:\\output.txt")));
            String a = "";
            FileReader fr = new FileReader("H:\\test.txt");
            while ((i=fr.read()) != -1) {
               // System.out.print((char)i);
                a += (char)i;
                if (i == '\n') {
                    System.out.print(a);    
                    a = "";
                }
            }
            System.out.print(a);
            
            
            PrintWriter writer = new PrintWriter("H:\\test.txt","UTF-8");
            writer.println("hello");
            writer.close() ;

        } catch (Exception exc) {
            // TODO: handle exception
        }
        
        
    }
}
