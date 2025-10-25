# !/usr/bin/python3
# -*- coding: utf-8 -*-


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        len1 = len(haystack)
        len2 = len(needle)
        if (len1 < len2):
            return -1
        
        list1 = list(haystack)
        list2 = list(needle)

        for i in range(len1):
            index = i
            match = True
            for j in range(len2):
                char1 = list1[index]
                char2 = list2[j]
                if (char1 == char2):
                    index += 1
                else:
                    match = False
                    break

            if (match == True):
                return i
            elif (i == len1 - len2):
                return 0

        return -1

if __name__ == "__main__":
    solution = Solution()
    haystack = "abcdefgh"
    needle = "abxxxfgh"
    result = solution.strStr(haystack, needle)
    print("result: " + str(result))
