package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowCol = Integer.parseInt(console.nextLine());
        String[][] matrix = new String[rowCol][rowCol];
        int rowOfficer = -1;
        int colOfficer = -1;
        int[][] mirrorCoordinates = new int[2][2];
        int mirrorRow=0;
        for (int i = 0; i < rowCol; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = String.valueOf(input.charAt(j));
                if (input.charAt(j) == 'A') {
                    rowOfficer = i;
                    colOfficer = j;
                }
                if (input.charAt(j) == 'M') {
                    mirrorCoordinates[mirrorRow][0] = i;
                    mirrorCoordinates[mirrorRow][1] = j;
                    mirrorRow++;
                }
            }
        }
        int paidGold = 0;
        while (paidGold < 65) {
            String direction = console.nextLine();
            int oldRowOfficer = rowOfficer;
            int oldColOfficer = colOfficer;

            switch (direction) {
                case "up":
                    rowOfficer -= 1;
                    break;
                case "down":
                    rowOfficer += 1;
                    break;
                case "right":
                    colOfficer += 1;
                    break;
                case "left":
                    colOfficer -= 1;
                    break;
            }
            matrix[oldRowOfficer][oldColOfficer] = "-";
            if(officerInTheMatrix(rowOfficer, colOfficer, rowCol, rowCol)){
                if(matrix[rowOfficer][colOfficer].matches("\\d")){
                    paidGold += Integer.parseInt(matrix[rowOfficer][colOfficer]);
                }
                if(matrix[rowOfficer][colOfficer].equals("M")){
                        if(rowOfficer == mirrorCoordinates[0][0] && colOfficer == mirrorCoordinates[0][1]){
                            rowOfficer = mirrorCoordinates[1][0];
                            colOfficer = mirrorCoordinates[1][1];
                            matrix[mirrorCoordinates[0][0]][mirrorCoordinates[0][1]] = "-";
                        }
                        else {
                            rowOfficer = mirrorCoordinates[0][0];
                            colOfficer = mirrorCoordinates[0][1];
                            matrix[mirrorCoordinates[1][0]][mirrorCoordinates[1][1]] = "-";
                        }
                }
                matrix[rowOfficer][colOfficer] = "A";
            }
            else break;
        }
        if(officerInTheMatrix(rowOfficer, colOfficer, rowCol, rowCol)){
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }
        System.out.println("The king paid " + paidGold + " gold coins.");
        Arrays.stream(matrix).forEach(s -> {
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        });

    }

    private static boolean officerInTheMatrix(int row, int col, int rowMatrix, int colMatrix) {
        return row >= 0 && row <= rowMatrix - 1 && col >= 0 && col <= colMatrix - 1;
    }
}
