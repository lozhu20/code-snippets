package day.happy365.leetcode.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int length = in.nextInt();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = in.nextInt();
        }

//        int[] arr = new int[]{1, 5, 2, 7, 3};
//        int[] arr = new int[]{1, -2, 3, 4, -9, 7};
//        int[] arr = new int[]{1, -2, 3, 4, -9, 7};
        process(arr);
    }

    private static void process(int[] nums) {
        int index;
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for (index = 1; index < length; index++) {
            int[] subArr1 = new int[index];
            int[] subArr2 = new int[length - index];
            for (int i = 0; i < index; i++) {
                subArr1[i] = nums[i];
            }
            for (int i = index; i < length; i++) {
                subArr2[i - index] = nums[i];
            }

            int sum1 = sum(subArr1);
            int sum2 = sum(subArr2);

            int abs = Math.abs(sum1 - sum2);

            list.add(abs);
        }

        int maxVal = -1;
        for (Integer item : list) {
            if (item > maxVal) {
                maxVal = item;
            }
        }
        System.out.println(maxVal);
    }

    private static int sum(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return 0;
        }
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        return sum;
    }
}
