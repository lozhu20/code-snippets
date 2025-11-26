public class Solution11 {
    public static int maxArea(int[] arr) {
        int maxArea = 0;
        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 < p2) {
            int area = area(arr, p1, p2);
            if (area > maxArea) {
                maxArea = area;
            }

            if (arr[p1] < arr[p2]) {
                p1 = p1 + 1;
            } else {
                p2 = p2 - 1;
            }
        }

        return maxArea;
    }

    private static int min(int p1, int p2) {
        return Math.min(p1, p2);
    }

    private static int area(int[] arr, int p1, int p2) {
        int length = p2 - p1;
        int width = min(arr[p1], arr[p2]);
        return length * width;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 4, 3};
        int arr2[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int arr3[] = {1, 1};
        System.out.println(maxArea(arr2));
    }
}
