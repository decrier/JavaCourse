package reflection_examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    void sum(int a, int b){
        int result = a + b;
        System.out.println("Sum of " + a + " and " + b + " is: " + result);
    }

    void subtraction(int a, int b){
        int result = a - b;
        System.out.println("Difference of " + a + " and " + b + " is: " + result);
    }

    void multiplication(int a, int b){
        int result = a * b;
        System.out.println("Product of " + a + " and " + b + " is: " + result);
    }

    void division(int a, int b){
        int result = a * b;
        System.out.println("Quotient of " + a + " and " + b + " is: " + result);
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(
                new FileReader("test100.txt"))) {
            String methodName = reader.readLine();
            String firstArg = reader.readLine();
            String secondArg = reader.readLine();

            Calculator calc = new Calculator();
            Class cl = calc.getClass();
            Method method = null;

            Method[] methods = cl.getDeclaredMethods();
            for (Method myMethod: methods) {
                if (myMethod.getName().equals(methodName)) {
                    method = myMethod;
                }
            }

            method.invoke(calc, Integer.parseInt(firstArg), Integer.parseInt(secondArg));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
