import java.io.*;
/**
 *
 * @author Ethan Palser, Mathew Erwin, Michael Missana
 */
public class Assign1 {

    private BufferedWriter writer;
        
    public static void main(String args[]) {
        // file to read from
        File file = new File("testdata.txt");
        // file to write from, may change
        File log = new File("log.txt");
        // create a stream that will be reading from a file
        FileInputStream input = null;
        try{
            input = new FileInputStream(file);
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        // stream is for StreamReader and made efficient with a BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
       
        // main loop starts here
        String line;
        try{
            line = reader.readLine();
        }catch(IOException ex){
            line = String.valueOf((char)-1);
        }
        
        while(line.charAt(0) != -1){
            System.out.println("Hello");
        }
        
        int threadCount = Integer.valueOf(line);
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
