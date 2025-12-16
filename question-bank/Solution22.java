import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution22 {
    public static List<String> generateParenthesis(int n) {
        Set<String> bracketSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int left = i;
            int right = n - i;
            String base = "()".repeat(left);
            String temp = "(".repeat(right) + ")".repeat(right);
            int length = temp.length();
            for (int j = 0; j <= length; j++) {
                StringBuilder tmp = new StringBuilder(temp);
                tmp.insert(j, base);
                bracketSet.add(tmp.toString());
            }
        }
        return new ArrayList<>(bracketSet);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }
}
