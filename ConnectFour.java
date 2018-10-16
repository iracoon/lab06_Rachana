//rachana podaralla-lab05


//I added this comment to this code

import java.util.Scanner;

public class ConnectFour
{

    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);
        int boardHeight, boardWidth, columnChoice, row,
            currentPlayer = 1;
        boolean hasWon = false;

        System.out.print("What would you like the height of the board to be? ");
        boardHeight = myScanner.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        boardWidth = myScanner.nextInt();

        char[][] board = new char[boardHeight][boardWidth];
        initializeBoard(board);
        printBoard(board);

        System.out.println("\nPlayer 1: x");
        System.out.println("Player 2: o\n");

        //main game loop
        while (!hasWon)
        {
            //player 1 turn
            if(currentPlayer == 1)
            {
                System.out.print("Player 1: Which column would you like to choose? ");
                columnChoice = myScanner.nextInt();
                row = insertChip(board, columnChoice, 'x');
                printBoard(board);
                hasWon = boardFull(board);
                if(hasWon) break;
                hasWon = checkIfWinner(board, columnChoice, row,'x');
                if(hasWon)
                {
                    System.out.println("Player " + currentPlayer + " won the game!");
                }
                currentPlayer = 2;
            }
            //player 2 turn
            else
            {
                System.out.print("Player 2: Which column would you like to choose? ");
                columnChoice = myScanner.nextInt();
                row = insertChip(board, columnChoice, 'o');
                printBoard(board);
                hasWon = boardFull(board);
                if(hasWon) break;
                hasWon = checkIfWinner(board, columnChoice, row,'o');
                if(hasWon)
                {
                    System.out.println("Player " + currentPlayer + " won the game!");
                }
                currentPlayer = 1;
            }
        }
    }

    //inserts chip into board based on user decision
    public static int insertChip(char[][] array, int col, char chipType)
    {
        int row = 0;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i][col] == '-')
            {
                break;
            }
                row++;
        }
        array[row][col] = chipType;
        return row;
    }

    public static void printBoard(char[][] array)
    {
        for(int i = array.length - 1; i > - 1; i--)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //sets up blank board
    public static void initializeBoard(char[][] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                array[i][j] = '-';
            }
        }
    }

    //checks if board is empty
    public static boolean boardFull(char[][] array)
    {
        boolean isDraw = true;

        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                if(array[i][j] == '-')
                {
                    isDraw = false;
                }
            }
        }

        if(isDraw)
        {
            System.out.println("Draw. Nobody wins.");
            return true;
        }
        return false;
    }

    //checks if player has a win on board
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {
        int rowCount = 0, colCount = 0;

        //checks column
        for(int i = 0; i < array.length; i++)
        {
            if(array[i][col] == chipType)
            {
                rowCount++;
                if(rowCount == 4)
                {
                    return true;
                }
            }
            else
            {
                rowCount = 0;
            }
        }

        //checks row
        for(int i = 0; i < array[0].length; i++)
        {
            if(array[row][i] == chipType)
            {
                colCount++;
                if(colCount == 4)
                {
                    return true;
                }
            }
            else
            {
                colCount = 0;
            }
        }
        return false;
    }

}
