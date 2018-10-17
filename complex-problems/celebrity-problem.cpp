/*
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
*/

// C++ program to find celebrity
#include <bits/stdc++.h>
#include <list>
using namespace std;
 
// Max # of persons in the party
#define N 8
 
// Person with 2 is celebrity
bool  MATRIX[N][N] = {{0, 0, 1, 0},
                      {0, 0, 1, 0},
                      {0, 0, 0, 0},
                      {0, 0, 1, 0}};
 
bool knows(int a, int b)
{
    return MATRIX[a][b];
}
 
// Returns -1 if celebrity is not present.
// If present, returns id  (value from 0 to n-1).
int findCelebrity(int n)
{
    // Handle trivial case of size = 2
 
    stack<int> s;
 
    int C; // Celebrity
 
    // Push everybody to stack
    for (int i=0; i<n; i++)
        s.push(i);
    
    while (s.size() > 1)
    {
	    A = s.pop()
	    B = s.pop()
        if (knows(A, B))
        {
           s.push(B);
        }
        else
        {
		 s.push(A);
        }
    }
 
    // Potential candidate?
    C = s.pop();
 
    // Check if C is actually a celebrity or not
    for (int i = 0; i < n; i++)
    {
        // If any person doesn't know 'a' or 'a'
        // doesn't know any person, return -1
        if ( (i != C) &&
                (knows(C, i) || !knows(i, C)) )
            return -1;
    }
 
    return C;
}
 
// Driver code
int main()
{
    int n = 4;
    int id = findCelebrity(n);
    id == -1 ? cout << "No celebrity" :
               cout << "Celebrity ID " << id;
    return 0;
}

