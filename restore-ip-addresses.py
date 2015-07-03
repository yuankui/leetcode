import unittest
import socket

class Solution:
    # @param {string} s
    # @return {string[]}
    def restoreIpAddresses(self, s):
        self.ips = []
        self.recursive(s, 4, [])
        return self.ips

    def recursive(self, leftStr, leftNum, concated):
        if (leftStr == ""):
            return

        if leftNum == 1:
            concated.append(leftStr)
            self.outputIp(concated)
            concated.pop()
            return

        for length in range(1, 3+1):
            num = leftStr[:length]
            if num.startswith('0') and num != '0':
                continue
            concated.append(leftStr[:length])
            self.recursive(leftStr[length:], leftNum-1, concated)
            concated.pop()

    def outputIp(self, nums):
        '''最后一步验证ip合法性'''
        for num in nums:
            if int(num) >=256:
                return
            if num.startswith('0') and num != '0':
                return

        numStrs = nums
        ip = ".".join(numStrs)

        if not self.validIp(ip):
            return

        self.ips.append(ip)
        pass

    def validIp(self, ip):
        try:
            socket.inet_aton(ip)
            return True
        except socket.error:
            pass
        return False




class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testRestoreIpAddress(self):
        a = "1212101201"
        print self.s.restoreIpAddresses(a)

        a = "0000"
        print self.s.restoreIpAddresses(a)

        a = "010010"
        res = self.s.restoreIpAddresses(a)
        print res

