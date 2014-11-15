package Sort;

/**
 * Created by wlf on 11/14/14.
 */
public class QuickSort {

/*
Not stable
O(lg(n)) extra space
O(n^2)time, but typically O(n lg(n)) time
*/

    public static void quickSort(int[] a, int p, int r){
        if(p<r){
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }

    private static int partition(int[] a, int p, int r){
        int pivot = a[r];
        int i = p;

        for (int j=p; j<r; j++){
            if(a[j] >= pivot){
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

}
