import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class NQueens {

    public static boolean isSafe(
            int row,
            int col,
            char[][] board
    ) {
        int size = board.length;

        //vertical
        for (int r = 0; r < size; r++) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }
        //horizontal
        for (int c = 0; c < size; c++) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }

        //UL
        for (int c = col, r = row; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //UR
        for (int c = col, r = row; r >= 0 && c < size; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //BL
        for (int c = col, r = row; r <size && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //BR
        for (int c = col, r = row; r <size && c < size; r++, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(
            char[][] board
    ){
        for(int r = 0 ;r<board.length;r++){
            for(int c = 0 ;c<board.length;c++){
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Solve without pre-placement of queen
     *
     * @param board
     * @param col
     */
    public static void solveMazeByBtV2(
            char[][] board,
            int col
    ){
        if(col==board.length){
            System.out.println("SOL found");
            printBoard(board);
            return;
        }

        for(int r = 0; r<board.length; r++){
            if(isSafe(r,col,board)){
                board[r][col]='Q';
                solveMazeByBtV2(board,col+1);
                board[r][col]='.';
            }
        }

    }

    /**
     * Solve with a pre-placed queen
     *
     * @param board
     * @param col
     * @return
     */
    public static boolean solveMazeByBt(
            char[][] board,
            int col
    ){
        if(col==board.length){
            System.out.println("SOL found");
            printBoard(board);
            return true;
        }

//        for(int r = 0; r<board.length; r++) {
//            if(board[r][col]=='Q'){
//
//            }
//        }

        boolean found = false;
        for(int r = 0; r<board.length; r++){
            if(board[r][col]=='Q'){
                return solveMazeByBt(board,col+1);
            }

            if(isSafe(r,col,board)){
                board[r][col]='Q';
                found = solveMazeByBt(board,col+1) || found;
                board[r][col]='.';
            }
        }

        return found;
    }

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);

        char[][] board = {
                {'.','.','.','.'},
                {'.','.','.','.'},
                {'.','.','.','.'},
                {'.','.','.','.'},
        };


//        solveMazeByBtV2(board,0);

        int row,col;
        System.out.println("Enter queen row");
        row = z.nextInt();
        System.out.println("Enter queen col");
        col = z.nextInt();

        board[row][col]='Q';
//        printBoard(board);

        boolean found = solveMazeByBt(board,0);
        if(!found){
            System.out.println("No SOL found!");
        }

    }


}
