class Pos(object):
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Solution(object):
    def maxArea(self, height):
        first = self.innerMaxArea(height)
        height.reverse()
        second = self.innerMaxArea(height)

        return max(first, second)

    def innerMaxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        stack = [Pos(0, 0)]
        maxArea = 0

        for i, h in enumerate(height):
            greater = self.findMinGreater(stack, h, 0, len(stack))
            if greater is not None:
                area = min(h, greater.y) * (i - greater.x)
                if area > maxArea:
                    maxArea = area
            if h > stack[-1].y:
                stack.append(Pos(i, h))

        return maxArea

    def findMinGreater(self, list, value, start, end):
        if end - start <= 3:
            for i in range(start, end):
                if list[i].y >= value:
                    return list[i]
            return None
        midIndex = (start + end) / 2
        mid = list[midIndex]

        if mid.y == value:
            return mid
        elif mid.y < value:
            return self.findMinGreater(list, value, midIndex, end)
        else:
            return self.findMinGreater(list, value, start, midIndex)


if __name__ == '__main__':
    print Solution().maxArea([4, 6, 2, 7, 3])
    print Solution().maxArea([1, 2])
