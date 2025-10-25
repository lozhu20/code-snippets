package day.happy365.leetcode.p2;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int[] nodes = new int[]{0, 3, 5, 7, -1, -1, 2, 4};
//        int[] nodes = new int[]{0, 1, 2, 3, 4, -1, 5, 6};
//        int[] nodes = new int[]{0, 1, 2};
//        int[] nodes = new int[]{0, 5, 9, 8, -1, -1, 7, -1, -1, -1, -1, -1, 6};

//        Scanner in = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            list.add(in.nextInt());
//        }
//        System.out.println("===");
//
//        int[] nodes = new int[list.size()];
//        for (int i = 1; i < list.size(); i++) {
//            nodes[i] = list.get(i);
//        }
        process(nodes);
    }

    private static void process(int[] nodes) {
        List<Integer> resultList = new ArrayList<>();
        int length = nodes.length;
        if (length == 0 || length == 1) {
            throw new IllegalArgumentException("参数错误");
        }
        if (length == 2) {
            System.out.println(nodes[1]);
            return;
        }
        if (length == 3) {
            System.out.println(nodes[1] + " " + nodes[2]);
        } else {
            // 1.最小叶子节点
            Set<Integer> leafNodeIndexList = new HashSet<>();
            for (int i = 1; i < length; i++) {
                if (nodes[i] == -1) {
                    int parentNodeIndex = i / 2;
                    int left = parentNodeIndex * 2;
                    int right = parentNodeIndex * 2 + 1;
                    if (nodes[left] == -1 && nodes[right] == -1 && nodes[parentNodeIndex] != -1) {
                        leafNodeIndexList.add(parentNodeIndex);
                    }
                } else if (i >= (length / 2)) {
                    leafNodeIndexList.add(i);
                }
            }

            List<Integer> list = new ArrayList<>(leafNodeIndexList);
            int smallestIndex = list.get(0);
            for (Integer item : leafNodeIndexList) {
                if (nodes[item] < nodes[smallestIndex]) {
                    smallestIndex = item;
                }
            }

            resultList.add(smallestIndex);

            while (smallestIndex >= 1) {
                smallestIndex = smallestIndex / 2;
                resultList.add(smallestIndex);
            }
            for (int i = resultList.size() - 2; i >= 0; i--) {
                System.out.print(nodes[resultList.get(i)] + " ");
            }
        }
    }
}
