package work_with_files.programmer2;

import work_with_files.programmer1.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationEx2 {
    public static void main(String[] args) {
        Employee employee;
        try(ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("employees2.bin")
        )) {
            employee = (Employee) inputStream.readObject();
            System.out.println(employee);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
