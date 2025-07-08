package reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException
            , IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class employeeClass = Class.forName("reflection_examples.Employee");

//        Object o = (Employee)employeeClass.newInstance();

        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Object obj1 = constructor1.newInstance();

        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object obj2 = constructor2.newInstance(5, "Kolja", "IT");
        System.out.println(obj2);

        Method method = employeeClass.getMethod("setSalary", double.class);
        method.invoke(obj2, 1000);
        System.out.println(obj2);
    }
}
