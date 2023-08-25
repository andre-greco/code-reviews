package tech.andreagreco;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReaderTest {
    private void readFile(String fileName) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        in = new FileInputStream("input.txt");
        out = new FileOutputStream("output.txt");

        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
    }
}
