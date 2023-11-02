class StackArray{
    int[] stack;
    int top = -1;

    public StackArray(){
        stack = new int[2];
        top++;
    }

    public void push(int data){
        if(top == this.stack.length) stack = expand(stack.length);
        this.stack[top++] = data;
    }

    public int pop(){
        if(top == 0) return -1;
        int result = stack[top-1];
        stack[top-1] = 0;
        top--;
        return result;
    }

    private int[] expand(int size){
        int[] newStack = new int[size*2];
        for(int i = 0; i < size; i++){
            newStack[i] = stack[i];
        }
        return newStack;
    }

    public void display(){
        for(int i = 0; i < stack.length; i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }

}

public class StackUsingArray {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray();
        stackArray.display();
        System.out.println(stackArray.pop());
        stackArray.push(1);
        System.out.println(stackArray.pop());
        stackArray.display();
        stackArray.push(2);
        stackArray.display();
        stackArray.push(3);
        stackArray.display();
        System.out.println(stackArray.pop());
        stackArray.push(4);
        stackArray.display();
        stackArray.push(5);
        stackArray.display();
        System.out.println(stackArray.pop());
        stackArray.push(6);
        stackArray.display();
    }
    //push
    //pop
    //display
    //isEmpty
    //peek

}
