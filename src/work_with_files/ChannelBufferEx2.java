package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx2 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("test5.txt", "r");
           FileChannel channel = file.getChannel(); ) {

            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            buffer.rewind(); // возвращает текущую позицию на нулевую отметку
            System.out.println((char) buffer.get());
            System.out.println("-------------------------------------");

            buffer.compact(); // копирует непрочитанные байты в начало буфера, буфер готов к записи
            // новых байтов, начиная с последнего байта в буфере
            channel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            System.out.println("-------------------------------------");

            buffer.clear();
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());

            buffer.mark(); // ставит метку
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());

            buffer.reset(); // возвращает на метку
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
