package chat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> history = new ArrayList<>();
        boolean flag = true;
        System.out.println("""
                Доступные команды:
                Операции: +, -, *, /
                Служебные: clear, history, save [file], load [file], exit
                По умолчанию файл: history.txt
                """);
        while (true) {
            String line = readLine(scan, "Введите команду/операцию: ");
            String[] tokens = line.split("\\s+");
            String cmd = tokens[0].toLowerCase();
            String fileArg = tokens.length > 1 ? tokens[1] : "history.txt";
            switch (cmd) {
                case "exit" -> {
                    flag = false;
                    scan.close();
                    return;
                }
                case "clear" -> {
                    history.clear();
                    System.out.println("История очищена");
                    continue;
                }
                case "history" -> {
                    printHistory(history);
                    continue;
                }
                case "save" -> {
                    try {
                        saveHistory(history, fileArg);
                        System.out.println("История сохранена в: " + fileArg);
                    } catch (IOException e) {
                        System.out.println("Ошибка сохранения: " + e.getMessage());
                    }
                }
                case "load" -> {
                    try {
                        history = loadHistory(fileArg);
                        System.out.println("История загружена из: " + fileArg);
                    } catch (IOException e) {
                        System.out.println("Ошибка загрузки: " + e.getMessage());
                    }
                    continue;
                }
            }

            double a = readDouble(scan, "Введите первое число: ");
            double b = readDouble(scan, "Введите второе число: ");
            String record = calculate(a, b, cmd);
            if (record.contains("=")) {
                history.add(record);
            }
        }
    }

    private static String readLine(Scanner scanner, String prompt) {
        while(true) {
            System.out.println(prompt);
            String s = scanner.nextLine().toLowerCase().trim();
            if (!s.isEmpty()) {
                return s;
            }
            //System.out.println("Незнакомая команда/операция. Попробуйте еще раз");
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String s = scanner.nextLine().toLowerCase().trim().replace(',', '.');
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число");
            }
        }
    }

    private static boolean isBinaryOp(String oper) {
        return switch (oper) {
            case "+", "-", "/", "*" -> true;
            default -> false;
        };
    }

    private static void printHistory(List<String> history) {
        if(history.isEmpty()) {
            System.out.println("История пуста");
            return;
        }
        System.out.println("История:");
        for(String s : history) {
            System.out.println(s);
        }
    }

    private static void saveHistory(List<String> history, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, history, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static List<String> loadHistory(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) throw new NoSuchFileException(fileName);
        return new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
    }

    private static String calculate(double a, double b, String oper) {
        double res = 0;
        switch (oper) {
            case "+" -> res = a + b;
            case "-" -> res = a - b;
            case "*" -> res = a * b;
            case "/" -> {
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено");
                    return "Операция неудачна";
                }
                res = a / b;
            }
            case "^" -> res = Math.pow(a, b);
            case "%" -> res = a % b;
            default -> {
                System.out.println("Незнакомый операнд");
                return "Операция неудачна";
            }
        }
        String record = String.format("%.2f %s %.2f = %.2f", a, oper, b, res);
        System.out.printf("\nРезультат: %.2f\n", res);
        return record;
    }
}
