package sw.leetcode.two.sum;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {

        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[][] d = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            d[i][0] = nums[i];
            d[i][1] = i;
        }
        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int l = 0, r = nums.length - 1;
        int[] idx = new int[2];
        while (l < r) {
            int tmp = d[l][0] + d[r][0];
            if (tmp == target) {
                if(d[l][1]>d[r][1]){
                    idx[0] = d[r][1];
                    idx[1] = d[l][1];
                }else{
                    idx[0] = d[l][1];
                    idx[1] = d[r][1];
                }

                break;
            } else if (tmp < target) {
                l++;
            } else {
                r--;
            }
        }
        return idx;
    }
}
