package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by JMYE on 12/23/16.
 */
public class TwoSumDup {
    public static int[] findChoices(int[] menu, int money) {
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);
        for (int i = 0; i < sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length,complement);
            if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
                return indices;
            }
        }
        return new int[2];
    }

    public static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    public static int indexOf(int[] menu, int value, int excludeThis) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == value && i != excludeThis) {
                return  i;
            }
        }
        return  -1;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++ ) {
            Integer position = map.get(target - nums[i]);
            if (position == null) {
                map.put(nums[i],i);
            } else {
                return new int[]{position,i};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] menu = {1,9,5,4,2,7,5};
        int money = 10;
        for (int choie: findChoices(menu,money)) {
            System.out.println(choie);
        }

        for (int choie: twoSum(menu,money)) {
            System.out.println(choie);
        }

    }


}
