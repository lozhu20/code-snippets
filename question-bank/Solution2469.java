package day.happy365.leetcode.p1;

import java.util.Arrays;

public class Solution2469 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }

    public static void main(String[] args) {
        Solution2469 solution2469 = new Solution2469();
        System.out.println(Arrays.toString(solution2469.convertTemperature(36.50)));
        System.out.println(Arrays.toString(solution2469.convertTemperature(122.11)));
    }
}
