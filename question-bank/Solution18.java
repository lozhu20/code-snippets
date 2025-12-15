import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // 去重：跳过与前一个数重复的i（避免重复四元组）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // 去重：跳过与前一个数重复的j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    // 用long存储总和，避免int溢出（关键！）
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 去重：跳过left的重复值
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 去重：跳过right的重复值
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // 移动指针继续找下一组
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] numbers = {1, 0, -1, 0, -2, 2};
//        int[] numbers = {-2, -1, 0, 0, 1, 2};
//        int target = 0;
        int[] numbers = {2, 2, 2, 2, 2};
        int target = 8;
//        int[] numbers = {0, 0, 0, 0};
//        int target = 1;
//        int[] numbers = {-2, -1, -1, 1, 1, 2, 2};
//        int target = 0;
        List<List<Integer>> lists = Solution18.fourSum(numbers, target);
        System.out.println(lists);
    }
}

