# encoding: utf-8

# 动态规划: x,y的总方案数f(x,y)=f(x-1,y) + f(x,y-1)
# 有障碍的f(x,y) = 0
class Solution:
    # @param {integer} m
    # @param {integer} n
    # @return {integer}
    def __init__(self):
        self.f = {}

    def uniquePathsWithObstacles(self, obstacleGrid):

        self.obstacleGrid = obstacleGrid
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        for y in range(0, m):
            for x in range(0, n):
                res = self.calcF(x,y)
                self.putF(x,y,res)

        return self.getF(n-1, m-1)

    def calcF(self, x, y):
        if self.obstacleGrid[y][x] != 0:
            return 0
        if x == 0 and y == 0:
            return 1
        return self.getF(x,y-1) + self.getF(x-1,y)
            
    def getF(self, x,y):
        if x < 0 or y < 0:
            return 0
        return self.f[(x,y)]

    def putF(self, x,y,result):
        self.f[(x,y)] = result

if __name__ == '__main__':
    s = Solution()

    obs = [
        [0,0,0],
        [0,1,0],
        [0,0,0]
    ]

    print s.uniquePathsWithObstacles(obs)
    print s.uniquePathsWithObstacles([[0,0],[1,1],[0,0]])
    print s.uniquePathsWithObstacles([[1,0]])


