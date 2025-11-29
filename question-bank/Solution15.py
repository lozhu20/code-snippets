#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from typing import List


class Solution15:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        length = len(nums)

        if len(nums) < length:
            return []

        res = []
        for p1 in range(0, length - 1):
            his = {}
            for p2 in range(p1 + 1, length):
                rev_num = 0 - nums[p2]
                for pos, val in his.items():
                    item = [nums[p1], nums[pos], nums[p2]]
                    if rev_num == val and self.appendRes(res, item):
                        res.append(item)
                his[p2] = nums[p1] + nums[p2]
        return res

    def appendRes(self, res: List[List[int]], item: List[int]):
        if len(res) == 0:
            return True

        f = True
        for list in res:
            if self.isSame(list, item):
                f = False
        return f

    def isSame(self, list1: List[int], list2: List[int]):
        return set(list1) == set(list2)


if __name__ == "__main__":
    # nums = [-1, 0, 1, 2, -1, -4]
    # nums = [0, 1, 1]
    # nums = [0, 0, 0]
    nums = [-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0]
    solution = Solution15()
    res = solution.threeSum(nums=nums)
    print(res)
