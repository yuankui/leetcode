# encoding: utf-8

# 动态规划: x,y的总方案数f(x,y)=f(x-1,y) + f(x,y-1)
class Solution:
    # @param {integer} m
    # @param {integer} n
    # @return {integer}
    def __init__(self):
        self.f = {}

    def uniquePaths(self, m, n):
        for y in range(1, n):
            for x in range(1, m):
                res = self.getF(x,y-1) + self.getF(x-1,y)
                self.putF(x,y,res)

        return self.getF(m-1,n-1)

    def getF(self, x,y):
        if x == 0 or y == 0:
            return 1
        return self.f[(x,y)]

    def putF(self, x,y,result):
        self.f[(x,y)] = result

    def uniquePaths2(self, m, n):
        aux = [[1 for x in range(n)] for x in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                aux[i][j] = aux[i][j-1]+aux[i-1][j]
        return aux[-1][-1]

if __name__ == '__main__':
    s = Solution()
    print s.uniquePaths(3,7)
    print s.uniquePaths(1,2)

    print s.uniquePaths2(1,2)
