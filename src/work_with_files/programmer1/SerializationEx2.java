package work_with_files.programmer1;

import java.io.*;

public class SerializationEx2 {
    public static void main(String[] args) throws IOException {
        Car car = new Car("VW", "black");
        Employee emp1 = new Employee("Mariya", "IT", 28, 500, car);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("employees2.bin"))) {
            // Класс объекта должен имплементировать интерфейс Serializable!!!!!!!
            outputStream.writeObject(emp1);
            System.out.println("done!");
        }
    }
}
