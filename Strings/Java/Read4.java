/**
Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.

Method read4:

The API read4 reads four consecutive characters from file, then writes those characters into the buffer array buf4.

The return value is the number of actual characters read.

Note that read4() has its own file pointer, much like FILE *fp in C.

@Leetcode - https://leetcode.com/problems/read-n-characters-given-read4/
 */
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || buf.length == 0 || n == 0) {
            return 0;
        }
        int i = 0, bp = 0, len = 0;
        char[] buf4 = new char[5];
        
        while (i < n) {
            if (bp == len) {
                bp = 0;
                len = read4(buf4);
            }
            if (len == 0) {
                break;
            }
            buf[i++] = buf4[bp++];
        }
        return i;
    }
}
