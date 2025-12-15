import java.util.Arrays;

public class Solution16 {
    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        int closest = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                if (right > left + 1 && nums[right] == nums[right - 1]) {
                    continue;
                }

                int tempTarget = nums[i] + nums[left] + nums[right];
                int diff = tempTarget - target;

                int absDiff = Math.abs(diff);
                if (absDiff < closest) {
                    closest = absDiff;
                    r = tempTarget;
                }

                if (diff == 0) {
                    return 0;
                } else if (diff < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}

