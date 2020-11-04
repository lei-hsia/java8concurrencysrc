package deutsch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadLine {
    public static void main(String[] args) throws FileNotFoundException {
        //BufferedReader s = new BufferedReader(new InputStreamReader("input.dat"));
        FileReader input = new FileReader("input.dat");
        BufferedReader b1 = new BufferedReader(new FileReader("input.dat"));
        //BufferedReader b2 = new BufferedReader("input.dat");
        BufferedReader b3 = new BufferedReader(new FileReader("input.dat"));
    }
}
