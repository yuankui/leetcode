# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


def build_lists(lists):
    ret = []
    head = ListNode(None)
    for l in lists:
        p = head
        for v in l:
            p.next = ListNode(v)
            p = p.next
        ret += [head.next]
    return ret


class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        ret = []
        while True:
            min_value = (2 ** 32, -1)
            for i in range(len(lists)):
                lst = lists[i]
                if lst is None:
                    break
                if lst.val < min_value[0]:
                    min_value = (lst.val, i)
            if min_value[1] < 0:
                break
            min_v, min_i = min_value
            ret += [min_v]
            if lists[min_i].next is None:
                del lists[min_i]
            else:
                lists[min_i] = lists[min_i].next

        return build_lists([ret])


if __name__ == '__main__':
    lists = build_lists([
        [1, 4, 5],
        [1, 3, 4],
        [2, 6],
    ])

    ret = Solution().mergeKLists(lists)

    print ret
