package Array_String_Matrix;

/**
 * Created by wlf on 10/7/14.
 */
public class Add_Binary {
/*
    Given two binary strings, return their sum (also a binary string).

    For example,
            a = "11"
    b = "1"
    Return "100".
*/
public String addBinary(String a, String b) {
    if(a==null || a.length()==0){
        return b;
    }
    if(b==null || b.length()==0){
        return a;
    }
    StringBuilder sb = new StringBuilder();
    int indexA = a.length()-1;
    int indexB = b.length()-1;
    int signature = 0;
    while(indexA>=0 || indexB>=0){
        if(indexA==-1){
            while(indexB>=0){
                int x = (int)(b.charAt(indexB)-'0')+signature;
                if(x<=1){
                    sb.append(String.valueOf(x));
                    signature = 0;
                }else{
                    sb.append(String.valueOf(0));
                    signature = 1;
                }
                indexB--;
            }
        } else if(indexB==-1){
            while(indexA>=0){
                int x = (int)(a.charAt(indexA)-'0')+signature;
                if(x<=1){
                    sb.append(String.valueOf(x));
                    signature = 0;
                }else{
                    sb.append(String.valueOf(0));
                    signature = 1;
                }
                indexA--;
            }
        } else {
            int x = (int)(a.charAt(indexA)-'0')+(int)(b.charAt(indexB)-'0')+signature;
            if(x<=1){
                sb.append(String.valueOf(x));
                signature = 0;
            }else if(x==2){
                signature = 1;
                sb.append(String.valueOf(0));
            }else if(x==3){
                signature = 1;
                sb.append(String.valueOf(1));
            }
            indexA--;
            indexB--;
        }
    }
    if(signature==1){
        sb.append("1");
    }
    StringBuilder ret = sb.reverse();
    return ret.toString();
}
}
