package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {
    public static void main(String[] args) throws FileNotFoundException {
        try(RandomAccessFile file
                = new RandomAccessFile("test10.txt", "rw")) {
            int a = file.read(); //читает 1 байт на позиции, где стоит курсор, и сдвигает его
            System.out.println((char) a);

            String s1 = file.readLine(); // читает строку целиком
            System.out.println(s1);

            file.seek(101); // перемещает курсор на указанную позицию
            String s2 = file.readLine();
            System.out.println(s2);

            long position = file.getFilePointer();
            System.out.println(position);

//            file.seek(0);
//            file.writeBytes("privet");

            file.seek(file.length()-1); // перемещает курсор в конец файла
            file.writeBytes("\n\t\t\t\t\tWilliam Butler Yeats");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
