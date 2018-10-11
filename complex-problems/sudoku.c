#include<stdio.h>

#define MAX_ROW     9
#define MAX_COL     9

int sudoku[MAX_ROW][MAX_COL]= {{0, 0, 0, 0, 0, 0, 0, 9, 0},
                     	       {1, 9, 0, 4, 7, 0, 6, 0, 8},
                               {0, 5, 2, 8, 1, 9, 4, 0, 7},
                               {2, 0, 0, 0, 4, 8, 0, 0, 0},
                               {0, 0, 9, 0, 0, 0, 5, 0, 0},
                               {0, 0, 0, 7, 5, 0, 0, 0, 9},
                               {9, 0, 7, 3, 6, 4, 1, 8, 0},
                               {5, 0, 6, 0, 8, 1, 0, 7, 4},
                               {0, 8, 0, 0, 0, 0, 0, 0, 0}};;

int isSameRowHasN(int x, int y, int n)
{
    int i=0;

    for (i=0; i<MAX_ROW; i++) {
        if (sudoku[x][i] == n) {
            return 1;
        }
    }
    return 0;
}

int isSameColumHasN(int x, int y, int n)
{
    int j=0;

    for (j=0; j<MAX_COL; j++) {
        if (sudoku[j][y] == n) {
            return 1;
        }
    }
    return 0;
}

int isSameSquareHasN(int x, int y, int n)
{
    int i=0, j=0;

    if (x < 3) {
        x=0;
    } else if (x < 6) {
        x=3;
    } else {
        x=6;
    }

    if (y < 3) {
        y=0;
    } else if (y < 6) {
        y=3;
    } else {
        y=6;
    }

    for (i=x; i<x+3; i++) {
        for (j=y; j<y+3; j++) {
            if (sudoku[i][j] == n) {
                return 1;
            }
        }
    }
    return 0;
}

int solveSudoku(int x, int y)
{
    int n=1;

    if (x > MAX_ROW-1 && y > MAX_COL-1) {
	return 1;
    }

    if (sudoku[x][y] != 0) {
        // we already have a number
        if (y < MAX_COL-1) return solveSudoku(x, y+1);
        else if (x < MAX_ROW-1) return solveSudoku(x+1, 0);
        else return 1;
    }
    while (n < 10) {
        if (!isSameRowHasN(x,y,n) && !isSameColumHasN(x,y,n) && !isSameSquareHasN(x,y,n)) {
            sudoku[x][y] = n;
            if (y < MAX_COL-1) {
                if (solveSudoku(x, y+1)) return 1;
                else sudoku[x][y] = 0;
            } else if (x < MAX_ROW-1) {
                if (solveSudoku(x+1, 0)) return 1;
                else sudoku[x][y] = 0;
            } else return 1;
        }
        n++;
    }
    return 0;
}

void printSudoku()
{
   int i,j;

   printf("\n");

   for (i=0;i<MAX_ROW;i++) {
       for (j=0; j<MAX_COL;j++) {
           printf("%d  ", sudoku[i][j]);
       }
       printf("\n");
   }
}

int main()
{
    printSudoku();
    solveSudoku(0,0);
    printSudoku();
}
