import java.util.LinkedHashMap;
import java.util.Map;

public class Solution10 {
    public static boolean isMatch(String s, String p) {
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int ps = 0;
        int pp = 0;
        while (ps < sCharArray.length && pp < pCharArray.length) {
            char sChar = sCharArray[ps];
            char pChar = pCharArray[pp];
            char pNextPChar = pp >= pCharArray.length - 1 ? ' ' : pCharArray[pp + 1];
            if (pNextPChar != '*') {
                if (pChar == '.' || sChar == pChar) {
                    ps++;
                    pp++;
                } else {
                    return false;
                }
            } else {
                if (pChar != '.') {
                    if (sChar == pChar) {
                        ps = nextDifferentCharIndex(sCharArray, ps);
                    }
                } else {
                    ps = sCharArray.length;
                }
                pp += 2;
            }

            if ((isEnd(pCharArray, pp) && !isEnd(sCharArray, ps)) || (!isEnd(pCharArray, pp) && isEnd(sCharArray, ps))) {
                return false;
            }
        }

        return true;
    }

    private static int nextDifferentCharIndex(char[] charArray, int p) {
        int length = charArray.length;
        char currentChar = charArray[p];
        while (p < length && charArray[p] == currentChar) {
            p++;
        }

        return p > length ? length + 1 : p;
    }

    private static boolean isEnd(char[] charArray, int index) {
        return index > charArray.length - 1;
    }

    public static void main(String[] args) {
        String s = "aaab";
        String p = "a*ab";
        System.out.println(isMatch(s, p));
    }
}
