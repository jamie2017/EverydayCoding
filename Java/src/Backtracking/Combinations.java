package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianmei on 6/30/16.
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		dfs(rst, new ArrayList<Integer>(),1,n,k);
		return rst;
	}

	private void dfs(List<List<Integer>> rst,  List<Integer> list, int pos, int n, int k) {
		if (list.size() == k) {
			rst.add(new ArrayList<>(list));
			return;
		}
		for(int i = pos; i <= n; i++) {
			list.add(i);
			dfs(rst,list,i + 1,n,k);
			list.remove(list.size()-1);
		}
	}
}
