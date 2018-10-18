/*
Given an unsorted array of positive integers , find if there is an subset(even noncontiguous)  
in the array that sum upto a value "sum"

Youtube - https://www.youtube.com/watch?v=5td2QH-x5ck
*/

#include<stdio.h>
#include<stdbool.h>

bool subsetsumProblemDp(int num[], int size, int sum) {
  bool dp[size+1][sum+1];

  // 0 sum is always possible independent of input
  if (sum == 0) {return true;}

  for (int i=0; i<size+1; i++) {
    dp[i][0] = true;
  }
  for (int i=1; i<sum+1; i++) {
    dp[0][i] = false;
  }
  for (int i=1; i<size+1; i++) {
    for (int j=1; j<sum+1; j++) {
      if (dp[i-1][j] == true) {dp[i][j] = true;}
      else if (j >= num[i-1]) {dp[i][j] = dp[i-1][j-num[i-1]];}
      else {dp[i][j] = false;}
      }
  }
  printf("\n");
  for (int i=0; i<size+1; i++) {
    for (int j=0; j<sum+1; j++) {
      printf("%d  ", dp[i][j]);
    }
    printf("\n");
  }
  return (dp[size][sum]);
}

int main() {
  int num[] = {1,3,9,2};
  printf("\n%s\n", (subsetsumProblemDp(num, sizeof(num)/4, 5) == true)?"true":"false");
}
