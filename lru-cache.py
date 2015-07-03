from collections import OrderedDict
import unittest


class LRUCache:
    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity = capacity
        self.map = OrderedDict()
        self.size = 0

    # @return an integer
    def get(self, key):
        if key in self.map:
            value = self.map[key]
            del self.map[key]
            self.map[key] = value
            return value
        return -1

    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if key in self.map:
            self.map[key] = value
            self.get(key)
            return

        if self.size >= self.capacity:
            self.removeOldest()
        self.map[key] = value
        self.size += 1

    def removeOldest(self):
        for k in self.map.iterkeys():
            break
        self.size -= 1
        del self.map[k]


class SolutionTest(unittest.TestCase):
    def testCache(self):
        cache = LRUCache(1)
        cache.set(2, 1)
        print cache.get(2)
        cache.set(3, 2)
        print cache.get(2)
        print cache.get(3)

        print '----------------'
        cache = LRUCache(2)
        print cache.get(2)
        cache.set(2, 6)
        print cache.get(1)
        cache.set(1, 5)
        cache.set(1, 2)
        print cache.get(1)
        print cache.get(2)
