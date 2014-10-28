package Array_String_Matrix;

/**
 * Created by wlf on 9/18/14.
 */
public class KMP {

//    如果文本串的长度为n，模式串的长度为m，那么匹配过程的时间复杂度为O(n)，算上计算next的O(m)时间，KMP的整体时间复杂度为O(m + n)。

    public static void main(String[] args) {
        String p = "EXAMPLE";
        String s = "HERE IS AN SIMPLE EXAMPL EXAMPLE.";
        int[] next = new int[p.length()];
        GetNext(p, next);
        int index = KmpSearch(s, p, next);
        System.out.print(index);
    }


    public static void GetNext(String p, int[] next) {
        int pLen = p.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                ++j;
                ++k;
                //较之前next数组求法，改动在下面4行
                if (p.charAt(j) != p.charAt(k))
                    next[j] = k;   //之前只有这一行
                else
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
            } else {
                k = next[k];
            }
        }

    }

    public static int KmpSearch(String s, String p, int[] next) {

        int i = 0;
        int j = 0;
        int sLen = s.length();
        int pLen = p.length();
        while (i < sLen && j < pLen) {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        else
            return -1;
    }
}
