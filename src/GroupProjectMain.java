
import java.io.*;
import java.net.*; 

/**
 *
 * @author Ethan Palser, Mathew Erwin, Michael Missana
 */
public class GroupProjectMain {

    public static void main(String args[]) {
        // file to read from
        File file = new File("/Users/michaelmissana/desktop/testdata.txt"); // src dirctory not working
        // file to write from, may change
        File log = new File("/Users/michaelmissana/desktop/logdata.txt");

        int currentChar;
        try {
            // create a stream that will be reading from a file
            // stream is for StreamReader and made efficient with a BufferedReader
            FileInputStream input = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            int threadCount = 0;
            String parameter = ""; // builds the thread count read from file
            while ((currentChar = reader.read()) != -1) {
                //if new line character we have our limit parameter
                if (currentChar == (char) '\n') {
                    threadCount = Integer.valueOf(parameter);
                    // setup/initialize PatternManager
                    ServerThreadManager temp = ServerThreadManager.setInstance(threadCount, log);
                    temp.reset();
                    ClientThread[] threadArr = new ClientThread[ServerThreadManager.limit];
                    // populate terms with 0 and create each thread without starting them
                    for (int i = 0; i < ServerThreadManager.limit; i++) {
                        threadArr[i] = new ClientThread(i);
                    }
                    //start all threads for for our given limit
                    for (int i = 0; i < threadCount; i++) {
                        threadArr[i].start(); // starts thread which runs parallel to other threads
                    }
                    for (int i = 0; i < threadCount; i++) {
                        try {
                            threadArr[i].join(); // ensures all these threads must complete
                            } catch (InterruptedException ex) {
                            }
                    }
                    parameter = ""; //reset our parameter
                } else {
                    if ((char) currentChar != (char) 13) {
                        parameter += (char) currentChar;
                    }
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Exception" + ex);
        }
        ServerThreadManager.getInstance().close();
    }
}
