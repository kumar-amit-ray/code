/*
https://www.youtube.com/watch?v=xouin83ebxE&t=304s
*/

#include <stdio.h>

#define MAX_ROW 4
#define MAX_COL 4

int board[MAX_ROW][MAX_COL];
int position[MAX_ROW];

void initBoard()
{
    int i,j;

    for (i=0; i<MAX_ROW; i++) {
        for (j=0; j<MAX_COL; j++) {
            board[i][j] = 0;
        }
    }
    for (i=0; i<MAX_ROW; i++) {
        position[i] = -1;
    }
}

int isSafe(int row, int col) {
    int i,j;

    for (i=0; i<row; i++) {
        if ((i == row) || (position[i]==col) || (i+position[i] == row+col) || (i-position[j] == row-col)) {
           // we can't put queen here
           return 0;
        }
    }
    return 1;
}


int putQueen(int row, int col)
{
    int i;

    if (row == MAX_ROW) return 1;

    for (i=0; i<col; i++) {
        if (isSafe(row,i)) {
            position[row] = i;
            if (putQueen(row+1, col)) return 1;
            else position[row] = -1;
        }
    }
    return 0;
}

int displayBoard()
{
    int i;
    for (i=0; i<MAX_ROW; i++) {
        printf("%d  ", position[i]);
    }
}

int main()
{
    initBoard();
    displayBoard();
    putQueen(0,MAX_COL);
    displayBoard();
}
