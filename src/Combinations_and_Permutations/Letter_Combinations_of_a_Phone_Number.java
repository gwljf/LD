package Combinations_and_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlf on 10/8/14.
 */
public class Letter_Combinations_of_a_Phone_Number {
/*
    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    Note:
    Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        rec(ret, digits, new StringBuilder(), 0);
        return ret;
    }
    public void rec(List<String> ret, String digits, StringBuilder sb, int index){
        if(index==digits.length()){
            ret.add(new String(sb));
            return;
        }
        List<Character> list = getChar(digits.charAt(index));
        for(int i=0; i<list.size(); ++i){
            sb.append(list.get(i));
            rec(ret, digits, sb, index+1);
            sb.delete(sb.length()-1, sb.length());
        }
    }

    public List<Character> getChar(Character number){
        List<Character> ret = new ArrayList<Character>();
        if(number=='2'){
            ret.add('a');
            ret.add('b');
            ret.add('c');
        }else if(number=='3'){
            ret.add('d');
            ret.add('e');
            ret.add('f');
        }else if(number=='4'){
            ret.add('g');
            ret.add('h');
            ret.add('i');
        }else if(number=='5'){
            ret.add('j');
            ret.add('k');
            ret.add('l');
        }else if(number=='6'){
            ret.add('m');
            ret.add('n');
            ret.add('o');
        }else if(number=='7'){
            ret.add('p');
            ret.add('q');
            ret.add('r');
            ret.add('s');
        }else if(number=='8'){
            ret.add('t');
            ret.add('u');
            ret.add('v');
        }else if(number=='9'){
            ret.add('w');
            ret.add('x');
            ret.add('y');
            ret.add('z');
        }
        return ret;
    }
}
