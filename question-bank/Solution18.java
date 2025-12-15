package day.happy365.javademo.questionbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution17 {
    public static List<List<Integer>> fourSum(int[] numbers, int target) {
        int length = numbers.length;
        if (length < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        if (length == 4) {
            List<Integer> list = new ArrayList<>();
            for (int number : numbers) {
                list.add(number);
            }
            result.add(list);
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i <= length - 4; i++) {
            if (i < length - 4 && numbers[i] == numbers[i + 1] && numbers[i] == numbers[i + 2]) {
                continue;
            }
            for (int j = i + 1; j <= length - 3; j++) {
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    if (left < right - 1 && numbers[left] == numbers[left + 1]) {
                        left++;
                        continue;
                    }
                    if (right > left + 1 && numbers[right] == numbers[right - 1]) {
                        right--;
                        continue;
                    }

                    int tempTarget = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (tempTarget == target) {
                        List<Integer> list = List.of(i, j, left, right);
                        result.add(list);
                        break;
                    } else if (tempTarget < target) {
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
        int[] numbers = {1, 0, -1, 0, -2, 2};
        int target = 0;
//        int[] numbers = {2, 2, 2, 2, 2};
//        int target = 8;
        List<List<Integer>> lists = Solution17.fourSum(numbers, target);
        System.out.println(lists);
    }
}

