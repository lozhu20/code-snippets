# !/usr/bin/python3
# -*- coding: utf-8 -*-


class Solution:
    def match(self, text, pattern):
        text_list = list(text)
        pattern_list = list(pattern)
        index = 0
        while index < len(text_list):
            i = index
            j = 0
            while j < len(pattern_list):
                if (text_list[i] == pattern_list[j]):
                    i += 1
                    j += 1
                else:
                    break
            
            if j == len(pattern_list):
                return index
            elif i == len(text_list):
                return -1

            index += 1  

        return -1


if __name__ == "__main__":
    solution = Solution()
    text = "ABCABD"
    pattern = "BD"
    result = solution.match(text, pattern)
    print("result: %s" % result)
