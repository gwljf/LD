package Array_String_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlf on 9/17/14.
 */
public class Palindrome_Partitioning {
    public static void main(String[] args) {

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> done = new ArrayList<String>();
        rec(s, ret, done, 0);
        return ret;

    }

    public static void rec(String s, List<List<String>> ret, List<String> done, int curIndex){
        if (curIndex == s.length()){
            ret.add(new ArrayList<String>(done));
            return;
        }
        for (int i=curIndex; i<s.length(); ++i) {
            String sub = s.substring(curIndex, i+1);
            if (isPalindrome(sub)) {
                done.add(sub);
                rec(s, ret, done, i+1);
                done.remove(done.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s){
        if (s.length() == 0){
            return false;
        }

        int i=0, j=s.length()-1;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
