//Tic Tac Toe Game in Java using Minimax Algorithm
import java.util.Scanner;

public class TicTacToeMinimax {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            playerMove();
            if (checkWinner('X')) {
                printBoard();
                System.out.println("You win!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            
            computerMove();
            if (checkWinner('O')) {
                printBoard();
                System.out.println("Computer wins!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    static void playerMove() {
        printBoard();
        int move;
        while (true) {
            System.out.print("Enter your move (1-9): ");
            move = scanner.nextInt() - 1;
            int row = move / 3;
            int col = move % 3;
            if (move >= 0 && move < 9 && board[row][col] == ' ') {
                board[row][col] = 'X';
                break;
            }
            System.out.println("Invalid move, try again.");
        }
    }

    static void computerMove() {
        int[] bestMove = minimax(0, true);
        board[bestMove[1]][bestMove[2]] = 'O';
    }

    static int[] minimax(int depth, boolean isMaximizing) {
        if (checkWinner('X')) return new int[] {-1, -1, -1};
        if (checkWinner('O')) return new int[] {1, -1, -1};
        if (isBoardFull()) return new int[] {0, -1, -1};
        
        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int bestRow = -1, bestCol = -1;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = isMaximizing ? 'O' : 'X';
                    int score = minimax(depth + 1, !isMaximizing)[0];
                    board[i][j] = ' ';
                    
                    if ((isMaximizing && score > bestScore) || (!isMaximizing && score < bestScore)) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
        return new int[] {bestScore, bestRow, bestCol};
    }

    static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    static void printBoard() {
        System.out.println("\n  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(" ---+---+---");
        System.out.println("  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(" ---+---+---");
        System.out.println("  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}
