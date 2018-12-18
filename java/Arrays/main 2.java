import java.util.Arrays;

public class Main{

    public static int[] generateArray(int size, int min, int max){
        int newArray[] = new int[size];
        for(int i = 0; i < size; i++){
            newArray[i] = (int)(Math.random()*(max - min) + min);
        }
        return newArray;
    }

    public static int[][] generate2DArray(int size, int size2d, int min, int max){
        int new2DArray[][] = new int[size][size2d];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < new2DArray[i].length; j++){
                new2DArray[i][j] = (int)(Math.random()*(max - min) + min);
            }
        }
        return new2DArray;
    }

    public static void displayArray(int[] array){
        System.out.print("[ ");
        for(int i = 0; i < array.length; i++ ){

            if(i == array.length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");

        }
        System.out.print(" ]");
    }

    public static void display2DArray(int[][] array2D){
        System.out.println("");
        System.out.println("{");
        for(int i = 0; i < array2D.length; i++){
            System.out.print("  " + i + " => ");
            displayArray(array2D[i]);
            System.out.println(",");
        }
        System.out.println("}");
        System.out.println("");
    }

    public static void main(String[] args){
        int[][] new2DArray = generate2DArray(10, 20, 0, 50);
        display2DArray(new2DArray);
    }
}