class PosHeight:
    def __init__(self, pos, height):
        self.pos = pos
        self.height = height


class Solution(object):
    def trap(self, heights):
        """
        :type height: List[int]
        :rtype: int
        """
        dec_stack = [PosHeight(0, 0)]
        acc = 0
        for (pos, height) in enumerate(heights):
            if height < dec_stack[-1].height:
                dec_stack.append(PosHeight(pos, height))
            else:
                last_height = 0
                while len(dec_stack) > 0 and dec_stack[-1].height <= height:
                    posHeight = dec_stack.pop()
                    acc += (pos - posHeight.pos - 1) * (posHeight.height - last_height)
                    last_height = posHeight.height
                if len(dec_stack) > 0:
                    acc += (pos - dec_stack[-1].pos - 1) * (height - last_height)
                dec_stack.append(PosHeight(pos, height))

        return acc


if __name__ == "__main__":
    print Solution().trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])
    print Solution().trap([4, 2, 3])
