import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    char[][] myBoard = {{'*', '*', '*'},{'*', '*', '*'},{'*', '*', '*'}};
        int turn = 0;

        while (true) {
            printBoard(myBoard);
            char player = setPlayerChar(turn); //dictates whether the character is X or O
            int[] coords = takeCoords(); //takes the input of the coordinates for the move and returns it to main
            if (checkCoords(myBoard, coords, player)) { //check if coords already have a space
                setMove(myBoard, coords, player); //Goes to that coord on the board and puts the character there
                turn++;
                System.out.println("Turn number " + turn + ":"); //turn counter
                if (playerWins(myBoard, player)) {
                    System.out.println(player + " wins!"); //added to say WHAT player wins
                    break;
                }
            }
        }

    }
   private static char setPlayerChar(int turn){
       if (turn % 2 == 0) {
           char playerchar = 'X';
           return playerchar;
        } else {
           char playerchar = 'O';
           return playerchar;
       }
    }

    //Check for three in a row diagonally, horizontally, vertically.
    private static boolean playerWins(char[][] board, char player) {
        for (char[] row : board){
            if ((row[0] == player) && (row[1] == player) && (row[2] == player)) {
                return true;
            }

        }
        for (int i = 0; i < board.length; i++){
            if ((board[0][i] == player) && (board[1][i] == player) && (board[2][i] == player)) {
                return true;
            }

        }
            if ((board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player)) {
                return true;
            } else if ((board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player)) {
                return true;
        }

        return false;
    }


    //takes coordinate array & char & takes board (those are the params). Goes to that coord on the board and puts the character there
    private static void setMove (char[][] myBoard, int[] coords, char player) {
        myBoard[coords[0]][coords[1]] = player;

    }


    //takes the input of the coordinates for the move and returns it to main
    private static int[] takeCoords () {
        int[] currentMove = new int[2];
        System.out.println("Please enter the position you want for your move (example 0 0 )");
        Scanner sc = new Scanner(System.in);



        for (int i = 0; i < currentMove.length; i++) {
            currentMove[i] = sc.nextInt();
        }

        return currentMove;


    }

    //check to see if coordinates are already used
    private static boolean checkCoords (char[][] board, int[] coords, char player) {
        if (board[coords[0]][coords[1]] == 'X' || board[coords[0]][coords[1]] == 'O') {
            System.out.println("That spot is already taken! Please go again");
            return false;
        } else {
            return true;
        }
    }



    //    This function prints out the board to the console
    private static void printBoard (char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){
                if(j != board[i].length - 1) {
                    System.out.print(board[i][j]);
                    System.out.print(" | ");
                } else {
                    System.out.println(board[i][j]);

                }
            }
            if (i != 2) {
                System.out.println("---------");
            }
        }

    }

}
