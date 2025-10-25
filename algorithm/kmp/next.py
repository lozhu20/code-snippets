# !/usr/bin/python3
# -*- coding: utf-8 -*-


class Solution:
    def kmp_match(self, text, pattern):
        next = self.next(pattern)
        text_list = list(text)
        pattern_list = list(pattern)
        i = 0
        p = 0
        while i < len(text_list) and p < len(pattern_list):
            if text_list[i] == pattern_list[p]:
                i += 1
                p += 1
            else:
                p = p - next[p - 1]
        
            if p == len(pattern_list):
                return i - p

        return -1 


    def next(self, pattern):
        pattern_list = list(pattern)
        next = []
        next.append(0)
        i = 1
        lenth = 0
        while i < len(pattern_list):
            if pattern_list[i] == pattern_list[lenth]:
                lenth += 1
                next.insert(i, lenth)
                i += 1
            else:
                if lenth == 0:
                    next.insert(i, 0)
                    i += 1
                else:
                    lenth = next[lenth - 1]
        return next


if __name__ == "__main__":
    solution = Solution()
    text = "ABABABCAA"
    pattern = "ABABC"
    next = solution.next(pattern)
    print("next: ")
    print(next)

    result = solution.kmp_match(text=text, pattern=pattern)
    print("result: ")
    print(result)
