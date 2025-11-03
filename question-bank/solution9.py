# !/usr/bin/python3
# -*- coding: utf-8 -*-

import queue


class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x != 0 and x % 10 == 0):
            return False
        reversed_part = 0
        while x > reversed_part:
            reversed_part = reversed_part * 10 + x % 10
            x //= 10
        return x == reversed_part or x == reversed_part // 10
    
    def isPalindrome1(self, x: int) -> int:
        if x < 0 or (x != 0 and x % 10 == 0):
            return False
        num = x
        q = queue.Queue()
        while num > 0:
            n = num % 10
            q.put(n)
            num //= 10
        
        reversed_number = 0
        while not q.empty():
            n = q.get()
            reversed_number = reversed_number * 10 + n
        
        return x == reversed_number


if __name__ == "__main__":
    solution = Solution()
    x = 12321
    is_palindrome = solution.isPalindrome1(x)
    print(f"is palindrome: {is_palindrome}")
