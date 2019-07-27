import heapq

class PQClass:
    def __init__(self, array_index, elem_index, elem_value):
        self.array_index = array_index
        self.elem_index = elem_index
        self.elem_value = elem_value
  
    # when we push multiple elements in the heap, we need to define a __lt__ function.
    def __lt__(self, other):
        return self.elem_value < other.elem_value
 
 
 class Solution:
      def merge_k_sorted_array(self, arrays):
        merged_array = list()
        heap = list()
        if arrays is None or len(arrays) == 0:
            return merged_array

        # for every array insert the 0th elemet to min-heap to start with
        for array_index, array in enumerate(arrays):
            heapq.heappush(heap, PQClass(array_index, 0, array[0]))

        # repeatedly -
        #   - pop from heap (which is the current smallest element)
        #   - increment the element index of the same array, so that that arrays next element can be pushed to heap.
        #   - If there is no element in the current array, just don't push the next element.
        #   - in the next iteration, that next smallest element will be picked.
        while heap:
            smallest = heapq.heappop(heap)
            merged_array.append(smallest.elem_value)
            smallest.elem_index +=1
            if smallest.elem_index < len(arrays[smallest.array_index]):
                smallest.elem_value = arrays[smallest.array_index][smallest.elem_index]
                heapq.heappush(heap, smallest)

        return merged_array
