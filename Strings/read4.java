/*
Read N Characters Given Read4 II - Call multiple times

The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function may be called multiple times.
Example 1: 
Given buf = "abc"
read("abc", 1) // returns "a"
read("abc", 2); // returns "bc"
read("abc", 1); // returns ""
Example 2: 
Given buf = "abc"
read("abc", 4) // returns "abc"
read("abc", 1); // returns ""

From <https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/description/> 



It took me many hours by try and error as well as looking at many solutions to figure out the following 3 
key clarifications the question failed to provide.
With the provided clarifications, it's not difficult to think of a solution using a char buffer[5] 
to store results from read4() and then read chars from it.
	1. read4() has its own file pointer, much like FILE *fp in C.
// file is "abc", initially fp points to 'a'
read(1) // returns buf = "a", now fp points to 'b'
read(1) // returns buf = "b", now fp points to 'c'
read(2) // returns buf = "c", now fp points to end of file
	1. char *buf is destination not source, similar to that of scanf("%s", buf), OJ outputs this buf value.
	2. Each time read() is called, we need to provide a new buf to store read characters, therefore, 
  the return value of int read() is simply the length of buf.
  */
class Solution {
private:
    int bp = 0;
    int len = 0;
    char buffer[5];
public:
    int read(char *buf, int n) {
        int i = 0;
        while (i < n) {
            if (bp == len) {
                bp = 0;
                len = read4(buffer);
                if (len == 0)
                    break;
            }
            buf[i++] = buffer[bp++];
        }
return i;
    }
};
