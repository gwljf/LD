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
        if(numRows == 0){
            return tree;
        }
        layer.add(1);
        tree.add(new ArrayList<Integer>(layer));
        layer.clear();
        for(int layers=1; layers<numRows; ++layers){
            for(int index=0; index<=layers; ++index){
                if(index==0 || index==layers){
                    layer.add(1);
                }else{
                    layer.add(tree.get(layers-1).get(index-1)+tree.get(layers-1).get(index));
                }
            }
            tree.add(new ArrayList<Integer>(layer));
            layer.clear();
        }
        return tree;
    }
}
