/*
Given a regular expression String pattern find out if the pattern exist in a string.
*/


#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool findRegxPattern(char *pattern, char *str) {
	int mcnt=0, numstar=0;
	char *pat = pattern;
	bool gotstar=false;

	while (*str != '\0') {
		if (*pat == '\0') {
			gotstar = false;
			break;
		} else if (*pat == '*') {
			gotstar = true;
			str++;pat++;
			numstar++;
		} else if (*str == *pat) {
			gotstar = false;
			str++;pat++;
			mcnt++;	
		} else if (gotstar == true){
			str++;
		} else {
			pat = pattern;
			mcnt = 0;
			numstar=0;
			str++;
		}
	}
	if (mcnt == strlen(pattern) - numstar) {
		return true;
	} 
	return false;	
}

int main() {
	bool fnd = false;
	fnd = findRegxPattern("*gc*a*", "abdfgcfbabc");
	printf("\n%s", (fnd == true)?"found":"notfound");
	fnd = findRegxPattern("*a*", "abdfgcfbabc");
	printf("\n%s", (fnd == true)?"found":"notfound");
	fnd = findRegxPattern("*k*", "abdfgcfbabc");
	printf("\n%s", (fnd == true)?"found":"notfound");
	fnd = findRegxPattern("ab*ba", "abdfgcfbabc");
	printf("\n%s", (fnd == true)?"found":"notfound");
}
