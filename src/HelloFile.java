import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class HelloFile {
    public static void main(String[] args) throws IOException {
        write();
        File file = new File("demo.txt");
        Scanner scanner = new Scanner(file);
        System.out.println("Now we are reading from " + file.getName());
        String data;
        while(scanner.hasNextLine()){
            data= scanner.nextLine();
            System.out.println(data);
        }
    }
    private static void write() throws IOException {
        System.out.println("Hello File!");
        FileWriter writer = new FileWriter("demo.txt", true);
        writer.write(LocalDateTime.now()+"> Hello from Java\n");
        writer.write("by your robot friend\n");
        writer.close();
    }
}
