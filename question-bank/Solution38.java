import java.util.ArrayList;
import java.util.List;

public class Solution38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String tmp = "1";
        for (int i = 0; i < n - 1; i++) {
            tmp = count(tmp);
        }

        return tmp;
    }

    private static String count(String s) {
        char[] charArray = s.toCharArray();
        List<Object> list = new ArrayList<>();
        for (char t : charArray) {
            if (list.isEmpty()) {
                list.add(1);
                list.add(t);
            } else {
                char lastNum = (char) list.get(list.size() - 1);
                if (lastNum == t) {
                    int count = (int) list.get(list.size() - 2);
                    list.set(list.size() - 2, count + 1);
                } else {
                    list.add(1);
                    list.add(t);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Object i : list) {
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        String s = "3322251";
//        System.out.println(count(s));

        int n = 30;
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(n));
    }
}
