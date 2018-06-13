
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author Ethan Palser, Mathew Erwin, Michael Missana
 */
public class Assign1 {

    public static void main(String args[]) {
        PatternThread[] threadArr = new PatternThread[PatternManager.limit];

        // populate terms with 0 and create each thread without starting them
        for (int i = 0; i < PatternManager.limit; i++) {
            threadArr[i] = new PatternThread(i);
        }

        int currentChar; 
        //PrintWriter writer = new PrintWriter("H:\\test.txt","UTF-8");
        try {
            String parameter = "";
            FileReader fr = new FileReader("H:\\test.txt");
            while ((currentChar=fr.read()) != -1) {
               
                //if new line character we have our limit parameter
                if (currentChar == '\n') {
                    
                    //start all threads for for our given limit
                    //for (int i = 0; i < Integer.parseInt(parameter); i++) {
                        //threadArr[i].start(); // starts thread which runs parallel to other threads
                    //}
                    system.out.print(Integer.parseInt(parameter));

                    parameter = ""; //rest our parameter
                }else{
                    parameter += (char)currentChar;
                }

            }
        } catch (Exception exc) {
            // TODO: handle exception
        }
    }
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