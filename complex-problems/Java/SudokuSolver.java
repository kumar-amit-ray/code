/**
@Leetcode - https://leetcode.com/problems/sudoku-solver/
 */
class Solution {
    char[][] board;
    char[] validChars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        this.board = board;
        fillBoard(0, 0);
    }

    private boolean fillBoard(int row, int col) {
        if (row > board.length-1 && col > board[row].length-1) {
            return true;
        }
        // already filled cell
        if (board[row][col] != '.') {
            if (col <board[row].length - 1) {
                return fillBoard(row, col+1);
            } else if (row < board.length-1) {
                return fillBoard(row+1, 0);
            } else {
                return true;
            }
        }
        for (char currChar : validChars) {
            if (isSafe(currChar, row, col)) {
                board[row][col] = currChar;
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
        }
        return false;
    }

    private boolean isRowSafe(char num, int row) {
        for (int i=0; i<board[row].length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnSafe(char num, int col) {
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == num) {
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
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char num, int row, int col) {
        return (isRowSafe(num, row) && isColumnSafe(num, col) && isGridSafe(num, row, col));
    }

    private void printBoard() {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                System.out.print(" "+ board[i][j]);
            }
            System.out.print("\n");
        }
    }
  
  public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
                                      {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
                                      {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                                      {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
                                      {'.','.','.','.','8','.','.','7','9'}};
        Solution obj = new Solution();
        obj.solveSudoku(board);
        obj.printBoard();
    }
}
