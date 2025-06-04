package work_with_files;

import java.io.*;

public class CopyEx2 {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("1.jpg");
            FileOutputStream outputStream = new FileOutputStream("2.jpg")) {
            int i;
            while((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
            System.out.println("Done!");
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
