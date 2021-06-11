/**
@Leetcode - https://leetcode.com/problems/valid-sudoku/
 */
class Solution {
    char[][] board;
    char[] validChars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return fillBoard(0, 0);
    }
    
    private boolean fillBoard(int row, int col) {
        if (row > board.length-1 && col > board[row].length-1) {
            return true;
        }
        // already filled cell
        if (board[row][col] == '.') {
            if (col <board[row].length - 1) {
                return fillBoard(row, col+1);
            } else if (row < board.length-1) {
                return fillBoard(row+1, 0);
            } else {
                return true;
            }
        } 
        
        if (isSafe(board[row][col], row, col)) {
            if (col <board[row].length - 1) {
                if (fillBoard(row, col+1)) {return true;}
                else {board[row][col] = '.';}
            } else if (row < board.length-1) {
                if (fillBoard(row+1, 0)) {return true;}
                else {board[row][col] = '.';}
            } else {
                return true;
            }
        }
        
        return false;
    }

    private boolean isRowSafe(char num, int row, int col) {
        for (int i=0; i<board[row].length; i++) {
            if (i != col && board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnSafe(char num, int row, int col) {
        for (int i=0; i<board.length; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private int getGridNormalizedIndex(int index) {
        if (index>=0 && index<3) {return 0;}
        else if (index>=3 && index<6) {return 3;}
        else return 6;
    }

    private boolean isGridSafe(char num, int row, int col) {
        int nRow = getGridNormalizedIndex(row);
        int nCol = getGridNormalizedIndex(col);
        for (int i=nRow; i<nRow+3; i++) {
            for(int j=nCol; j<nCol+3; j++) {
                if (i == row && j == col) {continue;}
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char num, int row, int col) {
        return (isRowSafe(num, row, col) && isColumnSafe(num, row, col) && isGridSafe(num, row, col));
    }

}
