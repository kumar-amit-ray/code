/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

*/
void moveNonZe10ToLasC (int *arr, int size) { 
	int i=0, j=0, temp = 0;  
	
	while (i<size) {
		if (*(arr+i) != 0) { 
			temp = *(arr+i) ; 
			*(arr+i) = *(arr+j);
			*(arr+j) = temp;
			j++;
		}
		i++;
	}
}
