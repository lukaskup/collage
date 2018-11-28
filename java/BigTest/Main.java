public class Main{

  public static void printArray(int[] a){
    for(int i = 0; i < a.length; i++){
      System.out.println(a[i]);
    }
  }

  public static void printReverse(int[] a){
    for(int i = a.length - 1; i >= 0; i--){
      System.out.println(a[i]);
    }
  }

  public static int[] generateArray(int size, int min, int max){
    int[] a = new int[size];
    for(int i = 0; i < size; i++){
      a[i] = (int)(Math.random()*(max - min) + min);
    }
    return a;
  }

  public static void swapElements(int[] a, int i, int j){
    if(j >= a.length){
      System.out.println("value out of index");
      return;
    }

    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void draw(int n){
    for(int i = 1; i <= n; i += 2){
      String line = "";
      for(int j = 0; j < n; j++){
        if(j < i){
          line += " ";
        }else{
          line += "*";
        }
      }
      System.out.println(line);
    }
  }

  public static int changeBit(int n, int i){
    return (n ^ (1 << (i - 1)));
  }

  public static void main(String[] args){
    System.out.println(Integer.toBinaryString(32));
    System.out.println(Integer.toBinaryString(2));
    System.out.println(Integer.toBinaryString(changeBit(32, 2)));
    System.out.println(changeBit(32, 2));
  }
}
