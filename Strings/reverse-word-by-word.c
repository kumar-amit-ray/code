/*
Given an input string , reverse the string word by word. 

Example:
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 
	• A word is defined as a sequence of non-space characters.
	• The input string does not contain leading or trailing spaces.
	• The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
*/

//reverse a string from start to end
void reverseWord(char *str, int start, int end) {
    int i;
    char temp;
    
    while(start<end) {
        temp = *(str+start);
        *(str+start) = *(str+end);
        *(str+end) = temp;
        start++;end--;
    }
}

void reverseWords(char* str, int strSize) {
    int i;
    int start=0;
    
    //reverse the whole word.
    reverseWord(str, 0, strSize-1);
    //when a space is encountered, reverse each individual word.
    for (i=0; i<strSize; i++) {
        if (str[i] == ' ') {
            reverseWord(str, start, i-1);
            start = i+1;
        }
    }
    //last word does not have any following spaces, so take care of it.
    reverseWord(str, start, strSize-1);
}

In Python
==========
def reverse_string_with_index(str_input, start, end):
    str_input = list(str_input)
    while start<end:
        str_input[start], str_input[end] = str_input[end], str_input[start]
        start = start+1
        end = end-1
    return "".join(str_input)

def reverse_string_word_by_word(str_input):
    # reverse the entire string
    str_input = reverse_string_with_index(str_input, 0, len(str_input)-1)

    # reverse each word
    i=0
    start = 0
    while i < len(str_input):
        if str_input[i] == ' ':
            str_input = reverse_string_with_index(str_input, start, i-1)
            start = i+1
        i = i+1

    str_input = reverse_string_with_index(str_input, start, len(str_input)-1)
    print str_input
