import java.util.Scanner;

public class l18_18c_s19049{
    public static void main(String[] Args){
        InteractiveStack stack = new InteractiveStack(20);
        stack.start();
    }   
}

class StringStack{
    String stack = "";
    private int max;

    StringStack(int max){
        this.max = max;
    }

    public void push(String value){
        if(this.stack.length() < this.max)
            this.stack += value;
        else
            System.out.println("Sorry, but you reached max number of stack element");
    }

    public void pop(){
        if(this.stack.length() != 0)
            this.stack = this.stack.substring(0, this.stack.length() - 1);
        else
            System.out.println("Sorry you cant delete non existing stack");
    }

    public void print(){
        System.out.println(this.stack);
    }
}

class Browser{
    //homepage is google lets say
    String name;
    String currentUrl = "google.com";
    int currentIndex = 0;
    String[] history = {"google.com"};


    Browser(String name){
        this.name = name;
    }

    public void navigateTo(String url){
        String[] updatedHistory = new String[this.history.length + 1];
        for(int i = 0; i < this.history.length; i++){
            updatedHistory[i] = this.history[i];
        }

        updatedHistory[this.history.length] = url;
        this.history = updatedHistory;
        this.currentIndex++;
    }

    public void back(){
        if(this.currentIndex != 0)
        this.currentUrl = this.history[--this.currentIndex];
        else
            System.out.println("Sorry, but u cant back without hisory");
    }

    public void forward(){
        if(this.currentIndex == this.history.length)
            System.out.println("Sorry, you cant go forward, you are already at the top!");
        else
            this.currentUrl = this.history[++this.currentIndex];
    }

    public void printHistory(){
        System.out.println("[");
        for(int i = 0; i < this.history.length; i++){
            System.out.println(this.history[i]);
        }
        System.out.println("]");
    }
}

class InteractiveStack{

    int[] stack;
    int currentIndex = 0;
    int max;

    InteractiveStack(int size){
        this.stack = new int[size];
        this.max = size;
    }

    public void start(){
        System.out.println("Hello welcome to Interactive Stack");
        decisionsInput();
    }

    public void decisionsInput(){
        System.out.println("Give decision:");
        Scanner input = new Scanner(System.in);
        int decision = input.nextInt();
        if(decision == 0){
            System.out.println("Give me value to push:");
            push();
            decisionsInput();
        }else if(decision == 1){
            pop();
            decisionsInput();
        }else if(decision == -1){
            display();
        }else{
            System.out.println("who the fuck you think you are");
            decisionsInput();
        }
    }

    void push(){
        if(currentIndex > max){
            System.out.println("Sorry, but you reached max number of stack element");
        }else{
            System.out.println("Give value to push:");
            Scanner input = new Scanner(System.in);
            int value = input.nextInt();
            this.stack[this.currentIndex] = value;
            this.currentIndex++;
        }
    }

    void pop(){
        if(this.currentIndex != 0){
            this.stack[this.currentIndex - 1] = 0;
            this.currentIndex--;
        }else{
            System.out.println("Sorry but your stack is empty man");
        }
    }

    void display(){
        for(int i = 0; i < this.currentIndex; i++){
            System.out.println(this.stack[i]);
        }
    }
}