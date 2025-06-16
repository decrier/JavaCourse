package work_with_files.programmer1;

import java.io.Serializable;

public class Employee implements Serializable {
    static final long serialVersionUID = 1;
    String name;
    String department;
    int age;
    transient double salary; // !!!! информация поля, помеченная словом transient, не сериализуется
    Car car;

    public Employee(String name, String department, int age, double salary, Car car) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
