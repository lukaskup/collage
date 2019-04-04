import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class GUI0306 {
    public static void main(String[] args)
    {
        Spiewak s1 = new Spiewak("Darrey"){
            String spiewaj(){
                return "eeae";
            }
        };

        Spiewak s2 = new Spiewak("Darrey"){
            String spiewaj(){
                return "bebe";
            }
        };

        Spiewak s3 = new Spiewak("Houston"){
            String spiewaj(){
                return "a4iBBiii";
            }
        };

        Spiewak s4 = new Spiewak("Carrey"){
            String spiewaj(){
                return "oaooooooooooo";
            }
        };

        Spiewak s5 = new Spiewak("Madonna"){
            String spiewaj(){
                return "aAa";
            }
        };

        ArrayList<Spiewak> lista = new ArrayList<Spiewak>();
        lista.add(s1);
        lista.add(s2);
        lista.add(s3);
        lista.add(s4);
        lista.add(s5);

        Collections.sort(lista);

        for(int i = 0; i < lista.size(); i++ ){
            System.out.println(lista.get(i));
        }

    }
}

abstract class Spiewak implements Comparable<Spiewak>{
    static int ids = 0;
    private int id;
    private String name;

    public Spiewak(String name) {
        this.id = ++ids;
        this.name = name;
    }

    private int checkVolume(){
        char[] melody = this.spiewaj().toCharArray();
        char[] temp = new char[this.spiewaj().length()];

        int tempIndex = 0;
        for(int i = 0; i < this.spiewaj().length(); i++){
            if(!(new String(temp).contains(String.valueOf(melody[i])))){
                temp[tempIndex] = melody[i];
                tempIndex++;
            }
        }

        return new String(temp).trim().length();
    }

    public int compareTo(Spiewak s){
        if(this.checkVolume() == s.checkVolume()){
            if(this.name.compareTo(s.name) == 0){
                return this.id - s.id;
            }else{
                return this.name.compareTo(s.name);
            }
        }else{
            return s.checkVolume() - this.checkVolume();
        }
    }

    abstract String spiewaj();

    public static Spiewak najglosniej(Spiewak[] sp){
        Spiewak spiewak = new Spiewak("test"){
            @Override
            String spiewaj(){
                return "0";
            }
        };

        int highestValue = spiewak.spiewaj().length();

        for(Spiewak s : sp){
            char[] melody = s.spiewaj().toCharArray();
            char[] temp = new char[s.spiewaj().length()];

            int tempIndex = 0;
            for(int i = 0; i < s.spiewaj().length(); i++){
                if(!(new String(temp).contains(String.valueOf(melody[i])))){
                    temp[tempIndex] = melody[i];
                    tempIndex++;
                }
            }

            if(highestValue < new String(temp).trim().length()){
                highestValue = new String(temp).trim().length();
                spiewak = s;
            }
        }

        return spiewak;
    };

    public String toString(){
        return "(" + this.id + ")" + " " + this.name + ": " + this.spiewaj();
    }
}