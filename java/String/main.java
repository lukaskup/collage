public class main{

  public static void print(String string){
    System.out.println(string);
  }

  public static void main(String[] args){
    String sentence = "lorem ipsum dilore";

    print(sentence);
    print(sentence.replace("lorem", "ipsum"));
    print(sentence.concat(" lorem lorem lorem \n \n"));

    String[] words = sentence.split(" ");
    for(int i = 0; i < words.length; i++){
      print(words[i]);
    }
  }
}
