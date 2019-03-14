class Solution(object):
    def isMatch(self, s, p):
        m, l, r = self.is_match(s, p)
        return m

    def is_match(self, s, p):
        if p == '' and s == '':
            return True, [''], ['']
        if len(p) > 1:
            if p[1] == '*':
                # not match once
                m, l, r = self.is_match(s, p[2:])
                if m:
                    return m, [''] + l, [p[:2]] + r

                # match once and repeat
                if len(s) == 0:
                    return self.is_match(s, p[2:])
                if self.match(s[0], p[0]):
                    m, l, r = self.is_match(s[1:], p)
                    if m:
                        return True, [s[0]] + l, [p[0]] + r
                return False, None, None
            else:
                if len(s) == 0:
                    return False, None, None
                if self.match(s[0], p[0]):
                    m, l, r = self.is_match(s[1:], p[1:])
                    if m:
                        return True, [s[0]] + l, [p[0]] + r
                return False, None, None



        else:
            return self.match(s, p), [s], [p]
        if self.match(s[0], p[0]):
            m, l, r = self.is_match(s[1:], p[1:])
            if m:
                return True, [s[0]] + l, [p[0]] + r
        return False, None, None

    def match(self, a, b):
        if a == b:
            return True
        return len(a) == len(b) and (a == '.' or b == '.')


if __name__ == '__main__':
    o = Solution()
    s = "mississippi"
    p = "mis*is*p*."
    print o.is_match(s, p)
    s = "aab"
    p = "c*a*b"
    print o.is_match(s, p)
    s = "ab"
    p = ".*"
    print o.is_match(s, p)
    s = "ab"
    p = ".*c"
    print o.is_match(s, p)
