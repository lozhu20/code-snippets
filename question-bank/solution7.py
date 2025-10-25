# !/usr/bin/python3
# -*- coding: utf-8 -*-


class Solution:
    def reverse(self, x: int) -> int:
        num_str = str(x)
        stack = []
        sign = ""
        for index in range(len(num_str)):
            char = num_str[index]
            if (char == "-"):
                sign = char
            else:
                stack.append(num_str[index])
        if (len(sign) > 0):
            stack.append(sign)

        num_str = ""
        for index in range(len(stack)):
            char = stack.pop()
            num_str += char
        
        num = int(num_str)
        if (num > 2**31 - 1 or num < -2**31):
            return 0
        else:
            return num


if __name__ == "__main__":
    solution = Solution()
    x = 463847412
    reversed_x = solution.reverse(x)
    print("result: %d" % reversed_x)
