import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void main(String[] args){
        ReadFile readFile = new ReadFile();
        List<String> lista = readFile.getFileContent("C:/Users/lukasz/Desktop/collage/java/GUI/GUI0813/src/plik.txt", true);
    }
}