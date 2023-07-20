package test.demo1.泛型;

import java.util.ArrayList;

public class MyStack<E> {
    ArrayList<E> stack;
    int index;
    public MyStack(){
        stack = new ArrayList<>();
        index = -1;
    }

    public void push(E v){
        stack.add(v);
        index++;
    }

    public E pop(){
        E remove = stack.remove(index);
        index--;
        return remove;
    }
}
class test{
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        while (stack.index >= 0){
            System.out.println(stack.pop());
        }
    }
}
