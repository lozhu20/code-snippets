# !/usr/bin/python3
# -*- coding: utf-8 -*-


from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        ans = -1
        while start <= end:
            mid = start + (end - start) // 2
            if target <= nums[mid]:
                ans = mid
                end = mid - 1
            else:
                start = mid + 1
        return ans
    

if __name__ == "__main__":
    solution = Solution()
    nums = [1, 3, 5, 6]
    target = 2
    pos = solution.searchInsert(nums=nums, target=target)
    print(f"insert position is {pos}")
            