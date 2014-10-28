package Array_String_Matrix;

/**
 * Created by wlf on 9/19/14.
 */
public class Single_number {

    public static void main(String[] args) {


        int[] A = {7, 5, 5, 5, 6, 6, 6,};
        System.out.println(singleNumber(A));
//        for (int i=0; i<32; ++i) {
//            System.out.println((7>>i)&1);
//        }

    }

    public static int singleNumber(int[] A) {
        // 创建一个长度为32的数组countsPerBit，
        // countsPerBit[i]表示A中所有数字在i位出现的次数
        int[] countsPerBit = new int[32];
        int result = 0;
        for (int i = 31; i >= 0; --i) {
            for (int j = A.length - 1; j >= 0; --j) {
                if (((A[j] >> i) & 1) == 1) {
                    countsPerBit[i] = (countsPerBit[i] + 1) % 3;
                }
            }
            result |= (countsPerBit[i] << i);
        }
        return result;
    }
}
