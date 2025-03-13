//Java program to create a tic-tac-toe game
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Thread;
import java.lang.Math;

public class Main_TicTacToe {
    static boolean isFirstTime = true;
    static int playerScore, computerScore;

    static void isDraw(char[][] grid){
        boolean isDraw = true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(grid[i][j] == ' ')
                    isDraw = false;
            }
        }
        if(isDraw) {
            System.out.println("\n\tIts a Draw!");
            System.exit(0);
        }
    }

    static void isWinForPlayer(char[][]grid){           //Checking if player won
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == 'X' && grid[1][i] == 'X' && grid[2][i] == 'X') {
                displayGrid(grid);
                System.out.println("\n\tYou Win!");
                System.exit(0);
            }
            else if (grid[i][0] == 'X' && grid[i][1] == 'X' && grid[i][2] == 'X') {
                displayGrid(grid);
                System.out.println("\n\tYou Win!");
                System.exit(0);
            }
        }
        if(grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X'){
            displayGrid(grid);
            System.out.println("\n\tYou Win!");
            System.exit(0);
        }
        else if(grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X'){
            displayGrid(grid);
            System.out.println("\n\tYou Win!");
            System.exit(0);
        }
    }

    static void isWinForComputer(char[][] grid){    //Checking if computer won
        for(int i=0; i<3; i++) {
            //Row check
            if (grid[i][0] == 'O' && grid[i][1] == 'O' && grid[i][2] == 'O') {
                displayGrid(grid);
                System.out.println("\n\tComputer Wins!");
                System.exit(0);
            }
            //Column check
            else if (grid[0][i] == 'O' && grid[1][i] == 'O' && grid[2][i] == 'O') {
                displayGrid(grid);
                System.out.println("\n\tComputer Wins!");
                System.exit(0);
            }
        }
        //Diagonal Check
        if(grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
            displayGrid(grid);
            System.out.println("\n\tComputer Wins!");
            System.exit(0);
        }
        //Other diagonal check
        else if(grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O'){
            displayGrid(grid);
            System.out.println("\n\tComputer Wins!");
            System.exit(0);
        }
    }

    static void playerTurn(char[][] grid) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        isWinForComputer(grid); //checks if computer has won
        while(true) {
            try {
                System.out.print("\n\tSelect block number to place: ");
                int choice = scan.nextInt();
                if (choice == 1) {
                    if (grid[0][0] == ' ') {
                        grid[0][0] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 2) {
                    if (grid[0][1] == ' ') {
                        grid[0][1] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 3) {
                    if (grid[0][2] == ' ') {
                        grid[0][2] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 4) {
                    if (grid[1][0] == ' ') {
                        grid[1][0] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 5) {
                    if (grid[1][1] == ' ') {
                        grid[1][1] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 6) {
                    if (grid[1][2] == ' ') {
                        grid[1][2] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 7) {
                    if (grid[2][0] == ' ') {
                        grid[2][0] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 8) {
                    if (grid[2][1] == ' ') {
                        grid[2][1] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else if (choice == 9) {
                    if (grid[2][2] == ' ') {
                        grid[2][2] = 'X';
                        break;
                    }
                    else
                        System.out.println("\tEnter a different block number\n");
                }
                else{
                    System.out.println("\tEnter a valid block number between 0 to 9\n");
                }
            }
            catch(InputMismatchException ime){
                System.out.println("\tEnter a digit as block number.\n");
                playerTurn(grid); //since the above statement, if unbroken will lead into an infinite loop, so recursively calling to start over

            }
        }
        isWinForPlayer(grid);  //checks if player has won
        displayGrid(grid);
        Thread.sleep(1500); // 1.5 seconds
        computerTurn(grid);
    }
    static void computerDefence(char[][] grid)  throws InterruptedException {
        //System.out.println("CD Called------");
        //Thread.sleep(1500); // 1.5 seconds
        //Diagonal check (00 to 22)
        if(grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == ' '){
            grid[2][2] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[0][0] == 'X' && grid[1][1] == ' ' && grid[2][2] == 'X'){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[0][0] == ' ' && grid[1][1] == 'X' && grid[2][2] == 'X'){
            grid[0][0] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }

        //Diagonal check (20 to 02)
        else if(grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == ' '){
            grid[0][2] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[2][0] == 'X' && grid[1][1] == ' ' && grid[0][2] == 'X'){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[2][0] == ' ' && grid[1][1] == 'X' && grid[0][2] == 'X'){
            grid[2][0] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        //Row check
        for(int i=0; i<3; i++){
            if(grid[i][0] == 'X' && grid[i][1] == 'X' && grid[i][2] == ' '){
                grid[i][2] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if(grid[i][0] == 'X' && grid[i][1] == ' ' && grid[i][2] == 'X'){
                grid[i][1] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if(grid[i][0] == ' ' && grid[i][1] == 'X' && grid[i][2] == 'X') {
                grid[i][0] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
        }
        //Column check
        for(int j=0; j<3; j++){
            if(grid[0][j] == 'X' && grid[1][j] == 'X' && grid[2][j] == ' '){
                grid[2][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if(grid[0][j] == 'X' && grid[1][j] == ' ' && grid[2][j] == 'X'){
                grid[1][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if(grid[0][j] == ' ' && grid[1][j] == 'X' && grid[2][j] == 'X') {
                grid[0][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
        }
    }

    static void computerOffence1(char[][] grid) throws InterruptedException {
        //System.out.println("CO1 Called------");
        //Thread.sleep(1500); // 1.5 seconds
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == ' ' && grid[i][1] == 'O' && grid[i][2] == 'O') {
                grid[i][0] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[i][0] == 'O' && grid[i][1] == ' ' && grid[i][2] == 'O') {
                grid[i][1] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[i][0] == 'O' && grid[i][1] == 'O' && grid[i][2] == ' ') {
                grid[i][2] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
        }
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == ' ' && grid[1][j] == 'O' && grid[2][j] == 'O') {
                grid[0][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[0][j] == 'O' && grid[1][j] == ' ' && grid[2][j] == 'O') {
                grid[1][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[0][j] == 'O' && grid[1][j] == 'O' && grid[2][j] == ' ') {
                grid[2][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
        }
        if(grid[0][0] == ' ' && grid[1][1] == 'O' && grid[2][2] == 'O'){
            grid[0][0] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[0][0] == 'O' && grid[1][1] == ' ' && grid[2][2] == 'O'){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == ' '){
            grid[2][2] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }

        if(grid[2][0] == ' ' && grid[1][1] == 'O' && grid[0][2] == 'O'){
            grid[2][0] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[2][0] == 'O' && grid[1][1] == ' ' && grid[0][2] == 'O'){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == ' '){
            grid[0][2] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
    }

    static void computerOffence2(char[][] grid) throws InterruptedException {
        //System.out.println("CO2 Called------");
        //Thread.sleep(1500); // 1.5 seconds
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == 'O' && grid[i][1] == ' ' && grid[i][2] == ' ') {
                grid[i][1] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[i][0] == ' ' && grid[i][1] == 'O' && grid[i][2] == ' ') {
                grid[i][2] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[i][0] == ' ' && grid[i][1] == ' ' && grid[i][2] == 'O') {
                grid[i][1] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
        }
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == 'O' && grid[1][j] == ' ' && grid[2][j] == ' ') {
                grid[1][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[0][j] == ' ' && grid[1][j] == 'O' && grid[2][j] == ' ') {
                grid[2][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
            else if (grid[0][j] == ' ' && grid[1][j] == ' ' && grid[2][j] == 'O') {
                grid[1][j] = 'O';
                Thread.sleep(1500); // 1.5 seconds
                displayGrid(grid);
                playerTurn(grid);
            }
        }
        if(grid[0][0] == 'O' && grid[1][1] == ' ' && grid[2][2] == ' '){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[0][0] == ' ' && grid[1][1] == 'O' && grid[2][2] == ' '){
            grid[2][2] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[0][0] == ' ' && grid[1][1] == ' ' && grid[2][2] == 'O'){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }

        if(grid[2][0] == 'O' && grid[1][1] == ' ' && grid[0][2] == ' '){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[2][0] == ' ' && grid[1][1] == 'O' && grid[0][2] == ' '){
            grid[0][2] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
        else if(grid[2][0] == ' ' && grid[1][1] == ' ' && grid[0][2] == 'O'){
            grid[1][1] = 'O';
            Thread.sleep(1500); // 1.5 seconds
            displayGrid(grid);
            playerTurn(grid);
        }
    }

    static void computerOffence3(char[][] grid) throws InterruptedException {
        //System.out.println("CO3 Called------");
        //Thread.sleep(1500); // 1.5 seconds
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(grid[i][j] == ' '){
                    grid[i][j] = 'O';
                    Thread.sleep(1500); // 1.5 seconds
                    displayGrid(grid);
                    playerTurn(grid);
                }
            }
        }
    }

    static void generateRandom(char[][] grid)throws InterruptedException{
        int rand1, rand2;
        while (true) {
            //double = Math.random * (max - min + 1) - min
            rand1 = (int) (Math.random() * (2 - 0 + 1) + 0);
            rand2 = (int) (Math.random() * (2 - 0 + 1) + 0);
            if (grid[rand1][rand2] == ' ' && grid[rand1][rand2] != 'X') {
                if(rand1 != 1 && rand2 != 2) {   //step will avoid placing 'O' at the centre of board
                    grid[rand1][rand2] = 'O';
                    isFirstTime = false;
                    break;
                }
            }
        }
        Thread.sleep(1000); // 1.5 seconds
        displayGrid(grid);
        playerTurn(grid);
    }

    static void computerTurn(char[][] grid) throws InterruptedException {
        if(isFirstTime) {
            generateRandom(grid); // If the computer is playing it's first turn, then it will place 'O' at a random position
        }
        isWinForComputer(grid); //checks if computer has won
        isDraw(grid); //checks if the progress results in draw

        computerOffence1(grid);  //performs if computer is in a winning situation
        computerDefence(grid);   //performs if computer is in a losing situation
        computerOffence2(grid);  //else, performs an ideal move
        computerOffence3(grid);  //else, places 'O' at a first free location

        /*
        Thread.sleep(1500); // 1.5 seconds
        displayGrid(grid);
        playerTurn(grid);
        */
    }

    static void displayGrid(char[][] grid){
        System.out.println("\n\n\n\n\n\t\t  You: X\t\t\tComputer: O");
        System.out.println("\n\t            |             |            ");
        System.out.printf("\t      %c     |      %c      |      %c     \n",grid[0][0],grid[0][1],grid[0][2]);
        System.out.println("\t            |             |            ");
        System.out.println("\t -----------+-------------+------------");
        System.out.println("\t            |             |            ");
        System.out.printf("\t      %c     |      %c      |      %c     \n",grid[1][0],grid[1][1],grid[1][2]);
        System.out.println("\t            |             |            ");
        System.out.println("\t -----------+-------------+------------");
        System.out.println("\t            |             |            ");
        System.out.printf("\t      %c     |      %c      |      %c     \n",grid[2][0],grid[2][1],grid[2][2]);
        System.out.println("\t            |             |            ");
    }

    public static void main(String[] args) throws InterruptedException {
        char[][] grid = new char[3][3];
        for(int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid[i][j] = ' ';
            }
        }
        displayGrid(grid);
        playerTurn(grid);
        /*
            00  01  02
            10  11  12
            20  21  22
         */
    }
}
