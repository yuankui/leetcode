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

# Your Trie object will be instantiated and called as such:
# trie = Trie()
# trie.insert("somestring")
# print trie.startsWith("somes")
# print trie.search("somestring")
# print trie.search('dd')