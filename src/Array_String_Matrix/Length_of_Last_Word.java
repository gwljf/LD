package Array_String_Matrix;

/**
 * Created by wlf on 10/8/14.
 */
public class Length_of_Last_Word {

/*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

            For example,
    Given s = "Hello World",
    return 5.
*/

    public int lengthOfLastWord(String s) {
        if(s.length()==0){
            return 0;
        }
        int end = s.length()-1;
        while (s.charAt(end)==' '){
            if (--end<0){
                return 0;
            }
        }
        int length = 0;
        while (s.charAt(end)!=' '){
            ++length;
            if (--end<0){
                break;
            }
        }
        return length;
    }
}
