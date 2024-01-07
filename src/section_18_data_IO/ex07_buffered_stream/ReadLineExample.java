package section_18_data_IO.ex07_buffered_stream;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineExample {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new FileReader("src/section_18_data_IO/ex07_buffered_streamm/ReadLineExample.java")
        );

        int lineNo = 1;
        while(true) {
            String string = br.readLine();
            if(string == null) break;
            System.out.println(lineNo + "\t" + string);
            lineNo++;
        }

        br.close();
    }
}
