package Array_String_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlf on 9/28/14.
 */
/*


Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

        For example, given n = 3, a solution set is:

        "((()))", "(()())", "(())()", "()(())", "()()()"

*/

public class Generate_Parentheses {

    public static void main(String[] args) {
        List<String> ret = new ArrayList<String>();
        ret = generateParenthesis(2);
        for (String str : ret) {
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        generate(ret, n, 0, 0, new StringBuilder());
        return ret;
    }

    public static void generate(List<String> ret, int n, int left, int right, StringBuilder sb) {
        if (left < right) {
            return;
        }
        if (left == n && right == n) {
            ret.add(new String(sb.toString()));
            return;
        }
        if (left == n) {
            sb.append(")");
            generate(ret, n, left, right + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
            return;
        }
        sb.append("(");
        generate(ret, n, left + 1, right, sb);
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        generate(ret, n, left, right + 1, sb);
        sb.delete(sb.length() - 1, sb.length());
    }
}
