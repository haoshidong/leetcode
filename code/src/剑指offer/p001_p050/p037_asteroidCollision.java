package 剑指offer.p001_p050;

import java.util.Stack;

public class p037_asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        //stack存放当前不会碰撞的所有小行星
        Stack<Integer> stack = new Stack<>();
        for (int asteroid:asteroids){
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid){
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek()>0 && stack.peek() == -asteroid){
                stack.pop();
            }else if (stack.isEmpty() || asteroid > 0 || stack.peek() < 0 ){
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
