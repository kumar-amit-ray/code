'''
Celebrity Problem
In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.

• If A knows B, then A can’t be celebrity. Discard A, and B may be celebrity.
• If A doesn’t know B, then B can’t be celebrity. Discard B, and A may be celebrity.
• Repeat above two steps till we left with only one person.
• Ensure the remained person is celebrity. (Why do we need this step?)
We can use stack to verity celebrity.
1. Push all the celebrities into a stack.
2. Pop off top two persons from the stack, discard one person based on return status of HaveAcquaintance(A, B).
3. Push the remained person onto stack.
4. Repeat step 2 and 3 until only one person remains in the stack.
5. Check the remained person in stack doesn’t have acquaintance with anyone else.

Youtube Link for celebrity problem - https://www.youtube.com/watch?v=LtGnA5L6LIk
Leetcode - https://leetcode.com/problems/find-the-celebrity/
'''

# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
# def knows(a, b):

class Solution(object):
    def findCelebrity(self, n):
        """
        :type n: int
        :rtype: int
        """
        stack = list()

        for num in xrange(n):
            stack.append(num)

        while len(stack) > 1:
            A = stack.pop()
            B = stack.pop()
            if knows(A, B): stack.append(B)
            else: stack.append(A)


        C = stack.pop()

        for num in xrange(n):
            if num != C:
                if not knows(num, C) or knows(C, num): return -1

        return C
