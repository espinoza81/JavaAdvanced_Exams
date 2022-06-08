package Exams;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[][] matrix = new String[8][8];
        int rowBlack = -1;
        int colBlack = -1;
        int rowWhite = -1;
        int colWhite = -1;

        for (int i = 0; i < 8; i++) {
            String input = console.nextLine();
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = String.valueOf(input.charAt(j));
                if (input.charAt(j) == 'w') {
                    rowWhite = i;
                    colWhite = j;
                }
                if (input.charAt(j) == 'b') {
                    rowBlack = i;
                    colBlack = j;
                }
            }
        }

        while (true) {
            if ( isCapture(rowWhite-1, colWhite-1, "b", matrix)) {
                break;
            }
            if (isCapture(rowWhite-1, colWhite+1, "b", matrix)) {
                break;
            }
//            if (isCapture(rowWhite+1, colWhite-1, "b", matrix)) {
//                break;
//            }
//            if (isCapture(rowWhite+1, colWhite+1, "b", matrix)) {
//                break;
//            }
            if (rowWhite - 1 == 0) {
                char col = (char) ('a' + colWhite);
                System.out.println("Game over! White pawn is promoted to a queen at " + col + "8.");
                break;
            }

            matrix[rowWhite][colWhite] = "-";
            rowWhite--;
            matrix[rowWhite][colWhite] = "w";

//            if ( isCapture(rowBlack-1, colBlack-1, "w", matrix)) {
//                break;
//            }
//            if (isCapture(rowBlack-1, colBlack+1, "w", matrix)) {
//                break;
//            }
            if (isCapture(rowBlack+1, colBlack-1, "w", matrix)) {
                break;
            }
            if (isCapture(rowBlack+1, colBlack+1, "w", matrix)) {
                break;
            }
            if (rowBlack + 1 == 7) {
                char col = (char) ('a' + colBlack);
                System.out.println("Game over! Black pawn is promoted to a queen at " + col + "1.");
                break;
            }

            matrix[rowBlack][colBlack] = "-";
            rowBlack++;
            matrix[rowBlack][colBlack] = "b";
        }

    }
    public static boolean isCapture(int row, int col, String pawn, String[][] matrix){
        if(row>=0 && row<=7 && col>=0 && col<=7 && matrix[row][col].equals(pawn)){
            String captureColour = pawn.equals("b") ? "White" : "Black";
            char colCapture = (char) ('a' + col);
            System.out.println("Game over! " + captureColour + " capture on " + colCapture + (8-row) + ".");
            return true;
        }
        return false;
    }
}
