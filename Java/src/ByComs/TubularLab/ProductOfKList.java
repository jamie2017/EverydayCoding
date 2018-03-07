package ByComs.TubularLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 8/1/17.
 */
public class ProductOfKList {
    public List<List<Integer>> findProductOfKList(List<List<Integer>> input) {
        List<List<Integer>> ans = new ArrayList<>();
        if (input == null) {
            return ans;
        }
        helper(input, ans,0,new ArrayList<>());
        return ans;
    }


    private void helper(List<List<Integer>> input,List<List<Integer>> ans, int rowIdx, List<Integer> curProd) {
        if (rowIdx == input.size()) {
            ans.add(new ArrayList<>(curProd));
            return;
        }
        for (int i = 0; i < input.get(rowIdx).size(); i++) {
            int cur = input.get(rowIdx).get(i);
            curProd.add(cur);
            helper(input,ans,rowIdx + 1,curProd);
            curProd.remove(curProd.size() - 1);
        }
    }

    public List<List<Integer>> findProductOfKListOpt(List<List<Integer>> input) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < input.size();i++) {
            count *= input.get(i).size(); // assume each sublist has at least one element
        }
        List<Integer> tmp;
        for (int i = 0; i < count; i++) {
            int j = 1;
             tmp = new ArrayList<>();
             for (List<Integer> subList: input) {
                 tmp.add(subList.get((i/j) % subList.size()));
                 j *= subList.size();
             }
             ans.add(tmp);
        }
        return ans;
    }




    public static void main(String[] args) {
        ProductOfKList test = new ProductOfKList();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,2,3));
        input.add(Arrays.asList(4,5));
//        input.add(Arrays.asList(6,7,8,9));
        System.out.println(test.findProductOfKList(input));
        System.out.println(test.findProductOfKListOpt(input));


    }
}
