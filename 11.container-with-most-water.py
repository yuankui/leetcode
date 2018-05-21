class Solution(object):
    def maxArea(self, height):
        first = self.inner_max_area(height)
        height.reverse()
        second = self.inner_max_area(height)

        print first, second
        return max(first[0], second[0])

    def inner_max_area(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        stack = [(0, 0)]
        max_area = (0, 0, 0)

        for i, h in enumerate(height):
            greater = self.find_first_greater(stack, h, 0, len(stack))
            if greater is not None:
                area = min(h, greater[1]) * (i - greater[0])
                if area > max_area[0]:
                    max_area = (area, greater[0], i)
            if h > stack[-1][1]:
                stack.append((i, h))

        return max_area

    def find_first_greater(self, list, value, start, end):
        if end - start <= 3:
            for i in range(start, end):
                if list[i][1] >= value:
                    return list[i]
            return None
        mid_index = (start + end) / 2
        mid = list[mid_index]

        if mid[1] <= value:
            return self.find_first_greater(list, value, mid_index, end)
        else:
            return self.find_first_greater(list, value, start, mid_index + 1)