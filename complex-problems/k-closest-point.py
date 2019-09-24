'''
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

https://www.youtube.com/watch?v=eaYX0Ee0Kcg

'''

class Solution(object):
    def kClosest(self, points, K):
        """
        :type points: List[List[int]]
        :type K: int
        :rtype: List[List[int]]
        """
        if len(points) == 0 or points == None or K  == 0:
            return []
        dist = dict()
        result = list()

        for index, point in enumerate(points):
            dist[index] = math.sqrt(point[0] * point[0] + point[1] * point[1])

        heap = list()
        for key, val in dist.items():
            heapq.heappush(heap, PQClass(key, val))

        i = 0
        while i<K:
            elem = heapq.heappop(heap)
            result.append(points[elem.index])
            i +=1

        return result

class PQClass:
    def __init__(self, index, val):
        self.index = index
        self.val = val

    def __lt__(self, other):
        return self.val < other.val
