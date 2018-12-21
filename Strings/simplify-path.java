/*
Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Corner Cases:
	• Did you consider the case where path = "/../"?
In this case, you should return "/".
	• Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

Solution: Take a stack. When you get a '/',  push any directory name in stack. Ignore any more '/' or '.' When you get a '../', pop the top of the stack and ignore it.

*/
func simplifypath(path string) string {
    var sb string
    var s sstack

    tokens := strings.Split(path, "/")
    // check for empty string
    if len(tokens) == 0 {
        return ""
    }
    // check for "/" path	
    if len(path) == 1 {
        return path
    }
    s.stackinit()
    for _, token := range tokens {
        if token == ".." {
           if !s.isempty() {
               s.pop()
           }
        } else if token != "." && token != "" {
            s.push(token)
        }
    }
    for ;s.isempty()==false; {
        sb =  "/" + s.pop() + sb
    }

    return sb
}
