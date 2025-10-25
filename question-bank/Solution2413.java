package day.happy365.leetcode.p1;

public class Solution2413 {
    // n 和 2 的最小公倍数
    public int smallestEvenMultiple(int n) {
        if (n == 1) {
            return 2;
        }
        if (n % 2 == 0) {
            return n;
        }
        return n << 1;
    }

    public static void main(String[] args) {
        Solution2413 solution2413 = new Solution2413();
        System.out.println(solution2413.smallestEvenMultiple(5));
        System.out.println(solution2413.smallestEvenMultiple(6));
    }
}
