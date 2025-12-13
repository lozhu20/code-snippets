import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = map();
        List<String> strList = new ArrayList<>();
        char[] digitsCharArray = digits.toCharArray();
        for (char digit : digitsCharArray) {
            List<String> chars = map.get(digit);
            if (strList.isEmpty()) {
                strList.addAll(chars);
            } else {
                List<String> tempStrList = new ArrayList<>();
                for (String str : strList) {
                    for (String c : chars) {
                        tempStrList.add(str + c);
                    }
                }
                strList = tempStrList;
            }
        }

        return strList;
    }

    private static Map<Character, List<String>> map() {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
        return map;
    }

    public static void main(String[] args) {
        Solution17 solution = new Solution17();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
    }
}
