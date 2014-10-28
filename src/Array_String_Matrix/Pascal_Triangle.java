package Array_String_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlf on 10/7/14.
 */
public class Pascal_Triangle {
    /*

        Given numRows, generate the first numRows of Pascal's triangle.

        For example, given numRows = 5,
        Return

        [
                [1],
                [1,1],
                [1,2,1],
                [1,3,3,1],
                [1,4,6,4,1]
                ]
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tree = new ArrayList<List<Integer>>();
        List<Integer> layer = new ArrayList<Integer>();
        if (numRows == 0) {
            return tree;
        }
        layer.add(1);
        tree.add(new ArrayList<Integer>(layer));
        layer.clear();
        for (int layers = 1; layers < numRows; ++layers) {
            for (int index = 0; index <= layers; ++index) {
                if (index == 0 || index == layers) {
                    layer.add(1);
                } else {
                    layer.add(tree.get(layers - 1).get(index - 1) + tree.get(layers - 1).get(index));
                }
            }
            tree.add(new ArrayList<Integer>(layer));
            layer.clear();
        }
        return tree;
    }

    /*
        Given an index k, return the kth row of the Pascal's triangle.

        For example, given k = 3,
        Return [1,3,3,1].

        Note:
        Could you optimize your algorithm to use only O(k) extra space?
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> layer = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return layer;
        }
        layer.add(1);
        for (int layerIndex = 1; layerIndex <= rowIndex; ++layerIndex) {
            for (int index = layerIndex; index > 0; --index) {        // 这注意是大于0, 这样就不用考虑第一位是1了
                if (index == layerIndex) {
                    layer.add(1);
                } else {
                    layer.set(index, layer.get(index) + layer.get(index - 1));
                }
            }
        }
        return layer;
    }
}
