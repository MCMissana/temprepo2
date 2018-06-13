
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
            FileReader fr = new FileReader("testdata.txt");
            while ((currentChar=fr.read()) != -1) {
               
                //if new line character we have our limit parameter
                if (currentChar == '\n') {
                    
                    //start all threads for for our given limit
                    //for (int i = 0; i < Integer.parseInt(parameter); i++) {
                        //threadArr[i].start(); // starts thread which runs parallel to other threads
                    //}
                    System.out.print(Integer.parseInt(parameter));

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
