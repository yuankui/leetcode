import unittest


class Solution:
    # @param {string} s1
    # @param {string} s2
    # @param {string} s3
    # @return {boolean}
    def isInterleave(self, s1, s2, s3):
        x = len(s1)
        y = len(s2)
        z = len(s3)
        if (x + y) != z:
            return False

        f = self.initArray(x, y)

        for len1 in range(x + 1):
            for len2 in range(y + 1):
                if len1 == 0 and len2 == 0:
                    f[len1][len2] = True
                    continue

                if len1 + len2 > z:
                    continue

                case1 = (len1 - 1 >= 0) and f[len1 - 1][len2] and s3[len1 + len2 - 1] == s1[len1 - 1]
                case2 = (len2 - 1 >= 0) and f[len1][len2 - 1] and s3[len1 + len2 - 1] == s2[len2 - 1]
                f[len1][len2] = case1 or case2


        return f[x][y]

    def initArray(self, x, y):
        f = []
        for i in range(x + 1):
            tmp = []
            for j in range(y + 1):
                tmp.append(False)
            f.append(tmp)
        return f


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testisInterleave(self):
        expect, acturl = True, self.s.isInterleave("aabcc", "dbbca", "aadbbcbcac")
        self.assertEqual(expect, acturl)

        expect, acturl = False, self.s.isInterleave("aabcc", "dbbca", "aadbbbaccc")
        self.assertEqual(expect, acturl)

        expect, acturl = False, self.s.isInterleave("a", "b", "a")
        self.assertEqual(expect, acturl)
