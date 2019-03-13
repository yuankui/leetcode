class Solution(object):
    count = 1
    def pre_check(self, s, p):
        words = p.split('*')
        words = filter(lambda x: x != '', words)
        words = '?'.join(words)
        words = words.split('?')
        words = filter(lambda x: x != '', words)
        for word in words:
            if s.find(word) < 0:
                return False
        return True

    def isMatch(self, s, p, min_pattern_len=0):
        self.count += 1
        if not self.pre_check(s, p):
            return False
        if min_pattern_len == 0:
            min_pattern_len = len(p.replace('*', ''))

        if min_pattern_len > len(s):
            return False
        while p != p.replace('**', '*'):
            p = p.replace('**', '*')
        if len(p) == 0 and len(s) == 0:
            return True

        if len(s) == 0:
            return p[0] == '*' and self.isMatch(s, p[1:], min_pattern_len)

        if len(p) == 0:
            return False

        c = p[0]
        if c == '?' and len(s) > 0:
            return self.isMatch(s[1:], p[1:], min_pattern_len - 1)
        if c == '*':
            return self.isMatch(s, p[1:], min_pattern_len) or \
                   self.isMatch(s[1:], p, min_pattern_len)
        else:
            return c == s[0] and self.isMatch(s[1:], p[1:], min_pattern_len - 1)


if __name__ == '__main__':
    s = Solution()

    print s.isMatch(
        "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
        "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"
    )

    print s.count


