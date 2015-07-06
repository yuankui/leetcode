# coding=utf-8

class TrieNode:
    # Initialize your data structure here.
    def __init__(self):
        self.end = False
        self.children = {}


class Trie:

    def __init__(self):
        self.root = TrieNode()

    # @param {string} word
    # @return {void}
    # Inserts a word into the trie.
    def insert(self, word):
        p = self.root
        for char in word:
            if char not in p.children:
                p.children[char] = TrieNode()
            p = p.children[char]
        p.end = True


    # @param {string} word
    # @return {boolean}
    # Returns if the word is in the trie.
    def search(self, word):
        p = self.root
        for char in word:
            if char not in p.children:
                return False
            p = p.children[char]
        if p.end:
            return True
        else:
            return False


    # @param {string} prefix
    # @return {boolean}
    # Returns if there is any word in the trie
    # that starts with the given prefix.
    def startsWith(self, prefix):
        p = self.root
        for char in prefix:
            if char not in p.children:
                return False
            p = p.children[char]
        return True

class Solution:
    '''两种优化方案
    1. 每进行一步,要检查所有的方案,因此对于那些开始右重复的单词就可以复用之前的步骤
    2. 批量检查的时候,有个优化,将单词按字典序排序,这样,没扫过一个char,就可以缩小可选单词的范围

    ## 下面两步优化使效率提升几倍,但还是ac不了
    3. 优化removeComplete,判断当前右满足长度条件的单词才进行remove,否则remove也是白瞎
    4. 优化binarySearch
        4.1 将递归变成循环
        4.2 减少key计算的次数

    5. 重大优化!! 彻底去掉shrink和remove
        5.1 之前判断下一步是否能走的条件是根据条件shrink了之后,是否还有单词满足条件
        5.2 实际上判断是否有单词满足条件的更有效率的方法是:提交将单词计算好,用的时候直接看
            5.2.1 这里就需要把单词分片进行建立索引:比如abcd,需要将a,ab,abc,acbd都放入索引
            5.2.2 搜索过程中需要查询,直接看该单词split是否存在即可.


    '''

    def findWords(self, board, words):
        self.findWordsInner(board, words)

        return self.foundWords.keys()
        #return filter(lambda word: self.foundWords.get(word) is True, words)

    # @param {character[][]} board
    # @param {string} word
    # @return {boolean}
    def findWordsInner(self, board, words):
        self.lenY, self.lenX = len(board), len(board[0])
        self.used = {}
        self.board = board
        self.foundWords = {}
        self.wordMap = {}
        for word in words:
            self.wordMap[word] = True

        self.wordSplitMap = self.calcWordSplitMap(words)
        self.trieTree = self.calcTrieTree(words)

        for y, line in enumerate(board):
            for x, char in enumerate(line):
                if char not in self.trieTree.root.children:
                    continue
                self.used[(x, y)] = True
                self.search(board, (x,y), words, char, self.trieTree.root.children[char])
                self.used[(x, y)] = False
                if len(words) == 0:
                    return True

    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def validPos(self, pos):
        x, y = pos

        # 基本检查
        valid = 0 <= x and x < self.lenX \
                and 0 <= y and y < self.lenY \
                and not self.used.get(pos) is True

        return valid

    def search(self, board, pos, words, currentWord, trieTree):
        # 单词找到啦
        if trieTree.end:
            self.foundWords[currentWord] = True

        # 没有更多的单词啦,回退吧
        if len(trieTree.children) == 0:
            return

        for direction in Solution.directions:
            newX, newY = (pos[0] + direction[0], pos[1] + direction[1])
            newPos = (newX, newY)

            valid = self.validPos(newPos)
            if valid:
                char = board[newY][newX]
                newWord = currentWord + char
                wordExists = char in trieTree.children
                if wordExists:
                    self.used[newPos] = True
                    self.search(board, newPos, words, newWord, trieTree.children[char])
                    self.used[newPos] = False
        return

    def calcWordSplitMap(self, words):
        m = {"": True}
        for word in words:
            for i in xrange(1, len(word) + 1):
                m [word[:i]] = True
        return m

    def wordExists(self, word):
        return self.wordSplitMap.get(word) is True

    def calcTrieTree(self, words):
        tree = Trie()
        for word in words:
            tree.insert(word)
        return tree


import unittest


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testWordSplitMap(self):
        m = self.s.calcWordSplitMap(['abcd','efgh'])
        print sorted(m.keys())

    def testFindWord(self):
        # words = ["oath", "pea", "eat", "rain"]
        # board = [
        #     'oaan',
        #     'etae',
        #     'ihkr',
        #     'iflv'
        # ]
        #
        # print self.s.findWords(board, words)
        #
        # board, words = ["ab","cd"], ["ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"]
        # print self.s.findWords(board, words)
        #
        # board, words = ["a"], ["a","a"]
        # print self.s.findWords(board, words)
        pass
