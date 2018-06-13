import java.io.*;
/**
 *
 * @author Ethan Palser, Mathew Erwin, Michael Missana
 */
public class Assign1 {

    private BufferedWriter writer;
        
    public static void main(String args[]) {
        File file = new File("test.txt");
        File log = new File("log.txt");
        // create a stream that will be reading from a file
        FileInputStream input;
        try{
            input = new FileInputStream(file);
        }catch(FileNotFoundException ex){
            input = null;
        }
        // stream is for StreamReader and made efficient with a BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
       
        // main loop starts here
        
        int threadCount;
        try{
            threadCount = Integer.valueOf(reader.readLine());
        }catch(IOException ex){
            threadCount = 0;
        }
        PatternManager.setInstance(threadCount, log);
        
        
        PatternThread[] threadArr = new PatternThread[PatternManager.limit];
        // populate terms with 0 and create each thread without starting them
        for (int i = 0; i < PatternManager.limit; i++) {
            threadArr[i] = new PatternThread(i);
        }
        // start each thread
        for (int i = 0; i < PatternManager.limit; i++) {
            threadArr[i].start(); // starts thread which runs parallel to other threads
        }
        
        // main loop ends
        
    }
}
