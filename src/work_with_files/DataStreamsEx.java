package work_with_files;

import java.io.*;

public class DataStreamsEx {
    public static void main(String[] args) {
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("my_test.bin"));
            DataInputStream inputStream = new DataInputStream(new FileInputStream("my_test.bin"))) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
