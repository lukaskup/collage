import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.start();
    }

    public void start(){
        List<String> list = this.getFileContent("C:/Users/lukasz/Desktop/collage/java/GUI/GUI0813/src/plik.txt", true);
    }

    public static List getFileContent(String path, Boolean print){
        List<String> fileContent = new ArrayList<String>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                fileContent.add(line);
                if(print){
                    System.out.println(line);
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}