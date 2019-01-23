/*
  given list of dependencies, generate the build order. 
*/

package main

import "fmt"

type depType struct {
    version int
    dependVersion int
}

type edgeGraphNode struct {
    version  int
    dependencyList []*edgeGraphNode
}

func allocEdgeGraph() *edgeGraphNode {
    node := new(edgeGraphNode)
    node.version = 0
    return node
}

func (e *edgeGraphNode) allocEdgeGraphNode(version int) *edgeGraphNode {
    node := new(edgeGraphNode)
    node.version = version
    e.dependencyList = append(e.dependencyList, node)
    return node
}

func (e *edgeGraphNode) searchEdgeGraph(version int) *edgeGraphNode {
    if e.version == version {
        return e
    }
    for _, delem := range e.dependencyList {
        if delem.version == version {
            return delem
        }
        subtree := delem.searchEdgeGraph(version)
        if subtree != nil {
            return subtree
        }
    }
    return nil
}

func (e * edgeGraphNode)insertIntoEdgeGraph(dep depType) {
    node := e.searchEdgeGraph(dep.version)
    if node == nil {
        // insert at root
        node = e.allocEdgeGraphNode(dep.version)
        node.allocEdgeGraphNode(dep.dependVersion)
    } else {
        // insert at version node
        for _, delem := range node.dependencyList {
            // depedency already exist
            if delem.version == dep.dependVersion {
                return
            }
        }
        node.allocEdgeGraphNode(dep.dependVersion)
    }
}

func (e *edgeGraphNode)dependencyOrderRecursive(deplist *[]int, m map[int]int) {

    // process childs
    for _, node := range e.dependencyList {
        node.dependencyOrderRecursive(deplist, m)
    }
    // we don't want to add the virtual root 0
    if e.version == 0 {
        return
    }
    //add this node in dependency list if it is not already there
    if _, ok := m[e.version]; !ok {
        *deplist = append(*deplist, e.version)
        m[e.version] = e.version
    }
}

func (e *edgeGraphNode)getDependencyOrder() []int {
    deplist := make([]int, 0)
    m := make(map[int]int)

    e.dependencyOrderRecursive(&deplist, m)
    return deplist
}

func (e *edgeGraphNode)printEdgeGraph() {
    fmt.Printf("\nRoot:%d", e.version)
    fmt.Printf("[")
    for _, child:= range e.dependencyList {
        fmt.Printf("%d, ", child.version)
    }
    fmt.Printf("]")
    for _, child:= range e.dependencyList {
        child.printEdgeGraph()
    }
}

func TestVersionDependency() {
    root := allocEdgeGraph()
    root.insertIntoEdgeGraph(depType{1,2})
    root.insertIntoEdgeGraph(depType{1,3})
    root.insertIntoEdgeGraph(depType{1,4})

    root.insertIntoEdgeGraph(depType{2,5})
    root.insertIntoEdgeGraph(depType{2,6})

    root.insertIntoEdgeGraph(depType{6,7})

    root.insertIntoEdgeGraph(depType{3,6})
    root.insertIntoEdgeGraph(depType{4,7})

    root.printEdgeGraph()
    fmt.Printf("\n%+v", root.getDependencyOrder())
}
