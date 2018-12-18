public class Main{

  public static void print(String string){
    System.out.println(string);
  }

  public static void main(String[] args){
    String sentence = "Dominus vitae necisque";

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            System.out.println(word.toUpperCase());
        }

        sentence = sentence.toLowerCase();
        sentence  = sentence.replace("a", "z");
        sentence = sentence.trim();
        System.out.println(sentence);
        if(sentence.contains("c")){
            System.out.println("Yes it has C!");
        }
  }
}
