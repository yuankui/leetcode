class Solution(object):
    '''思路是用*将p划分成若干份，然后分三种情况：
    1. 如果分成了一份，说明没有*，那么就依次检查匹配即可
    2. 如果分成了两份，说明中间有一个*，那么久两边检查匹配即可
    3. 如果分成了>2分，那么就
        3.1 去掉匹配的头尾
            例如：aabbccdd vs a*b*c*d -> abbccd vs [b,c]
        3.2 然后依次用剩下的大单词，去吃掉（eat）右边的所有小单词，如果能吃完，就可以匹配，如果吃不完，就匹配不了。
    为什么可以这样？我们先回顾下小单词是怎么得来的？是有*分割而来的，也就是说，小单词周围是充斥着*，而*可以任意匹配，
    所以，如果大单词能够吃掉所有小单词，那么剩余的大单词的部分就可以被*匹配掉。如果吃不掉，那么无论*怎么变化，都匹配不了。
    '''
    def isMatch(self, s, p):
        seps = p.split('*')
        if len(seps) == 1:
            return self.matches(s, p) and len(s) == len(p)
        if len(seps) >= 2:
            if not self.matches(s, seps[0]):
                return False
            s = s[len(seps[0]):]

            if not self.matches(self.reverse(s), self.reverse(seps[-1])):
                return False
            s = s[:len(s) - len(seps[-1])]

        if len(seps) > 2:
            return self.eat(s, seps[1:-1])
        return True

    def eat(self, s, words):
        words = list(reversed(words))
        word = words.pop()
        while True:
            index = self.find(s, word)
            if index < 0:
                return False
            if len(words) == 0:
                return True
            # after
            s = s[index + len(word):]
            word = words.pop()

    def find(self, s, word):
        if len(s) < len(word):
            return -99999
        if self.matches(s, word):
            return 0
        else:
            return self.find(s[1:], word) + 1

    def reverse(self, s):
        return list(reversed(s))

    def matches(self, a, b):
        if len(a) < len(b):
            return False
        for i in range(0, len(b)):
            if not self.match_one(a[i], b[i]):
                return False
        return True

    def match_one(self, a, b):
        if a == b:
            return True
        return b == '?' or a == '?'


if __name__ == '__main__':
    s = Solution()

    print s.isMatch(
        "abcd",
        "*?*?*?*?"
    )
    print s.isMatch(
        "mississippi",
        "m??*ss*?i*pi"
    )
    print s.isMatch(
        "b",
        "?*?"
    )

