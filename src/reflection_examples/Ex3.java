package reflection_examples;

import java.lang.reflect.Field;

public class Ex3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10, "Kolja", "IT");
        Class classEmployee = Class.forName("reflection_examples.Employee");
        Field field = classEmployee.getDeclaredField("salary");
        field.setAccessible(true); // доступ к полю, даже private!!!!!!

        double salaryValue = (double) field.get(employee);
        System.out.println(salaryValue);

        field.set(employee, 1500);
        System.out.println(employee);
    }
}
