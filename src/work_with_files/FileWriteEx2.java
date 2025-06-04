package work_with_files;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteEx2 {
    public static void main(String[] args)  {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно! —\n" +
                "Вот последняя правда, открытая мной.\n";

        // potok, ukazannij v skobkah, zakroetsya avtomaticheski,
        // net neobhodimosti zakriwat ego wruchnuju v bloke "finally"
        // dlja etogo resurs dolzhen implementirovat interface "Autoclosable"
        try (FileWriter writer = new FileWriter("text1.txt", true)){
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            //writer.write(rubai);
            writer.write("Omar Hayam");
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
