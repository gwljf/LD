package Array_String_Matrix;

import java.util.Stack;

/**
 * Created by wlf on 9/19/14.
 */
public class Reverse_Words_in_a_String {

    public static void main (String[] args) {
        String a = "  a  ";
        String x = reverseWords(a);
        System.out.println(x);
    }

    public static String reverseWords(String s) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();

        for (int i=0; i<s.length(); ++i){
            if(s.charAt(i)==' ' && !stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                stack2.push(' ');
            } else if(s.charAt(i)!=' ') {
                stack1.push(s.charAt(i));
            }
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        if(sb.length()>0 && sb.substring(0,1).equals(" ")){
            sb.delete(0,1);
        }
        return sb.toString();
    }
}
