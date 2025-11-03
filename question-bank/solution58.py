# !/usr/bin/python3
# -*- utf-8 -*-


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        length = 0
        for i in range(len(s)):
            preChar = s[i - 1] if i > 1 else 0
            char = s[i]
            if char != " ":
                if preChar == " ":
                    length = 1
                else:
                    length += 1
        return length


if __name__ == "__main__":
    solution = Solution()
    s = "   fly me   to   the moon  Hello!"
    r = solution.lengthOfLastWord(s)
    print(f"r is {str(r)}")
