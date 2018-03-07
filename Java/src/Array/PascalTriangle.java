package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianmei on 6/14/16.
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) { // Pascal's Triangle I
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> row,pre = null;
		for (int i = 0; i < numRows; i++) {
			row = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				row.add(j == 0 || j == i ? 1: pre.get(j - 1) + pre.get(j));
			}
			res.add(row);
			pre = row;
		}
		return res;
	}
	public List<Integer> getRow(int rowIndex) {// Pascal's Triangle II
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int tmp = ret.get(j - 1) + ret.get(j);
				ret.set(j, tmp);
			}
			ret.add(1);
		}
		return ret;
	}


	public static void main (String[] argu) {
		PascalTriangle test = new PascalTriangle();
		int n = 5;
		List<List<Integer>> res;
		res = test.generate(5);
		for (int i = 0 ; i < n; i++) {
			for(int j = 0; j<= i; j++) {
				System.out.print(res.get(i).get(j));
			}
			System.out.println();
		}

		System.out.println(test.getRow(n));
	}
}
