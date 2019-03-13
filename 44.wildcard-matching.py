class Solution(object):
    def isMatch(self, s, p):
        seps = p.split('*')
        seps = filter(lambda x: x != '', seps)

    def left_find(self, s, word):
        c = word[0]

        if self.match(s[0], c):
            pos = self.left_find(s[1:], word[1:])
            if pos >= 0:
                return pos + 1
        else:
            return self.left_find(s[1:], word)

    def match(self, a, b):
        if a == b:
            return True
        return b == '?' or a == '?'


if __name__ == '__main__':
    s = Solution()

    print s.isMatch(
        "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
        "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"
    )
