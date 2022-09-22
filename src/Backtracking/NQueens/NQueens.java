package Backtracking.NQueens;
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public int N;
    private final List<List<Integer>> board;

    public NQueens(int N) {
        this.N = N;
        this.board = new ArrayList<>();
        for(int i = 0; i<this.N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j<this.N; j++) {
                row.add(0);
            }
            board.add(row);
        }
    }


    public void solveNQueens() {
        List<List<Integer>> initialBoard = new ArrayList<>(this.board);
        this.printPossibleSolutions(0, initialBoard);
        System.out.println("Number of ways: " + this.printNumberOfWays(0, initialBoard));
    }


    private void printPossibleSolutions(int currRow, List<List<Integer>> boardConfig) {
        if(currRow >= this.N) {
            System.out.println(boardConfig.toString());
            return;
        }

        for(int currCol = 0; currCol<this.N; currCol++) {
            if(this.isValidPlacement(currRow, currCol, boardConfig)) {
                boardConfig.get(currRow).set(currCol, 1);
                printPossibleSolutions(currRow+1, boardConfig);
            }
            //backtracking
            boardConfig.get(currRow).set(currCol, 0);
        }
    }


    private int printNumberOfWays(int currRow, List<List<Integer>> boardConfig) {
        if(currRow >= this.N) {
            return 1;
        }
        int ways = 0;
        for(int currCol = 0; currCol<this.N; currCol++) {
            if(this.isValidPlacement(currRow, currCol, boardConfig)) {
                boardConfig.get(currRow).set(currCol, 1);
                ways += printNumberOfWays(currRow+1, boardConfig);
            }
            //backtracking
            boardConfig.get(currRow).set(currCol, 0);
        }
        return ways;
    }


    private boolean isValidPlacement(int currRow, int currCol, List<List<Integer>> currBoard) {

        //We will check for the rows that are in above currRow because
        //we are starting from currRow as 0, we are sure that at any given instance,
        //there are no queens placed below the currRow.

        //Check in upward direction
        for(int i = 0; i<=currRow; i++) {
            if(currBoard.get(i).get(currCol) == 1) {
                return false;
            }
        }

        //Check in left direction
        for(int i = 0; i<=currCol; i++) {
            if(currBoard.get(currRow).get(i) == 1) {
                return false;
            }
        }

        //Check diagonally [left-upward]
        int tempCol = currCol;
        int tempRow = currRow;
        while(tempRow>=0 && tempCol>=0) {
            if(currBoard.get(tempRow).get(tempCol) == 1) {
                return false;
            }
            tempCol--;
            tempRow--;
        }

        //Check diagonally [upward-right]
        tempCol = currCol;
        tempRow = currRow;
        while(tempRow>=0 && tempCol<this.N) {
            if(currBoard.get(tempRow).get(tempCol) == 1) {
                return false;
            }
            tempCol++;
            tempRow--;
        }

        return true;
    }



}
