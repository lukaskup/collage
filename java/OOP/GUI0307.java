import java.lang.Iterable;
import java.util.Iterator;

public class GUI0307 {

    public static void main(String [] args) 
    {
        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        for (char z: napis)
            System.out.print(z + " ");
    
        System.out.println();

        napis.ustawPoczatek(2);
        napis.ustawKrok(3);

        for (char z: napis) 
            System.out.print(z + " ");

        napis.ustawPoczatek(2);
        napis.ustawKrok(3);

        napis.forEach(value -> {
            System.out.print(Character.toLowerCase(value));
        });
    }
}

class IterNap implements Iterable<Character>{
    private final String value;
    public int position;
    public int step = 1;

    IterNap(String value){
        this.value = value;
    }

    public Iterator<Character> iterator(){

        return new Iterator<Character>() {
            public boolean hasNext(){
                return position < value.length();
            }
        
            public Character next(){
                Character next = value.charAt(position);
                position += step;
                return next;
            }
        };
    }

    
    public void ustawPoczatek(int newPosition){
        this.position = newPosition;
    }

    public void ustawKrok(int newStep){
        this.step = newStep;
    }
}
