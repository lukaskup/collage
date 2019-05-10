import java.io.File;
import java.util.Scanner;
public class FileReaderr
{
    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        File file =
                new File("C:\\Users\\lukasz\\Desktop\\collage\\java\\GUI\\GUI0813\\src\\plik.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}