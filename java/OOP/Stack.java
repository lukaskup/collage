public class Stack{
    public static void main(String[] args){
        IntegerStack stack = new IntegerStack(1);
        stack.push(4);
        stack.push(5);
    }
    
}

class IntegerStack{
    private int[] data;
    private int index = 0;

    IntegerStack(int size){
        this.data = new int[size];
    }

    public void push(int value){
        this.data[this.index] = value;
        this.index++;
    }

    public int pop(){
        return this.data[this.index--];
    }

    public void print(){
        for(int i = 0; i < this.index; i++){
            System.out.println(this.data[i]);
        }
        System.out.println("");
    }
}