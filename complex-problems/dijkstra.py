'''
https://www.youtube.com/watch?v=XB4MIexjvY0&t=598s
'''
import sys

class Graph:
    def __init__(self):
        self.vertex = set()
        self.edges = dict()
        self.weight = dict()

    def add_vertex(self, v):
        self.vertex.add(v)

    def add_edge(self, sv, dv, distance):
        if sv not in self.vertex or dv not in self.vertex:
            return False
        if sv not in self.edges:
            self.edges[sv] = list()

        self.edges[sv].append(dv)
        self.weight[(sv, dv)] = distance

    def print_grapth(self):
        for key, value in self.weight.items():
            print key, value

    def get_next_unvisited_vertex(self, visited, shortest_path):
        min = None
        for key, value in shortest_path.items():
            if min is None or value < shortest_path[min] and key not in visited:
                min = key

        return min

    def dijkstra_helper(self, sv, visited, shortest_path):
        if sv is None:
            return
        visited.append(sv)
        for connected_vertex in self.edges[sv]:
            distance = shortest_path[sv]+self.weight[(sv, connected_vertex)]
            if shortest_path[connected_vertex] < distance:
                shortest_path[connected_vertex] = distance

        next_vertex = self.get_next_unvisited_vertex(visited, shortest_path)

        self.dijkstra_helper(next_vertex, visited, shortest_path)


    def dijkstra(self, sv):
        visited = list()
        shortest_path = dict()
        for v in self.vertex:
            # for the source vertex to itself set to 0, and for any other set to maxint
            if v == sv:
                shortest_path[v] = 0
            else:
                shortest_path[v] = sys.maxint

        self.dijkstra_helper(sv, visited, shortest_path)

        return shortest_path

if __name__ == '__main__':
    g = Graph()
    g.add_vertex('A')
    g.add_vertex('B')
    g.add_vertex('C')
    g.add_vertex('D')
    g.add_vertex('E')

    g.add_edge('A', 'B', 6)
    g.add_edge('A', 'D', 1)
    g.add_edge('D', 'B', 2)
    g.add_edge('B', 'E', 2)
    g.add_edge('B', 'C', 5)
    g.add_edge('C', 'E', 5)

    print g.dijkstra('A')
