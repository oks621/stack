package main.java;

public class MyStacks {
    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(11);
        myStack.push(111);
        myStack.push(1111);
        System.out.println(myStack);
        myStack.remove(2);
        System.out.println(myStack);
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        myStack.clear();
        System.out.println(myStack.size());
    }
}

