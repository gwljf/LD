package Array_String_Matrix;

/**
 * Created by wlf on 10/21/14.
 */
public class Digits_before_first_0 {

/*
    1,  intput:2340560

        output:  3 (234)

    2.  input: 110

        output: 2 (11)

    3.  input: 112

        output: 0
*/

    public static void main(String[] args){
        int num1 = 1204;
        int num2 = 12666003;
        int num3 = 120304;
        int num4 = -1030;
        System.out.println(numDigitsBeforeZero(num1));
        System.out.println(numDigitsBeforeZero(num2));
        System.out.println(numDigitsBeforeZero(num3));
        System.out.println(numDigitsBeforeZero(num4));
    }
    public static int numDigitsBeforeZero(int input) {
        if(input==0){
            return 0;
        }
        int inputValue = Math.abs(input);
        int inputLength = String.valueOf(inputValue).length();

        int tmp = inputValue;
        int count = 0;
        int digits = 0;
        for(int i=inputLength-1; i>=0; --i){
            int highestDigit = (tmp/Math.pow(10, i)==0) ? 0:(int)(tmp/Math.pow(10, i));
            tmp = tmp - (tmp/(int)Math.pow(10, i)*(int)Math.pow(10, i));
            if(highestDigit!=0){
                ++count;
                digits = digits*10+highestDigit;
            }else {
                int result = count*(int)Math.pow(10, String.valueOf(digits).length())+digits;
                return result;
            }
        }
        return 0;
    }
}
