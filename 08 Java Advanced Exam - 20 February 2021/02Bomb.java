package Exams_matrix;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowMatrix = Integer.parseInt(console.nextLine());
        String[] command = console.nextLine().split(",");
        String[][] matrix = new String[rowMatrix][rowMatrix];
        int[] playerPosition = new int[2];
        int bombNumber = fillTheMatrix(matrix, playerPosition, console);
        boolean endRoute = false;
        boolean foundAllBomb = false;

        for (String s : command) {
            move(s, playerPosition, rowMatrix);

            if (matrix[playerPosition[0]][playerPosition[1]].equals("B")) {
                System.out.println("You found a bomb!");
                bombNumber--;
                if(bombNumber==0){
                    foundAllBomb =true;
                    break;
                }
                matrix[playerPosition[0]][playerPosition[1]] = "+";
            }

            if (matrix[playerPosition[0]][playerPosition[1]].equals("e")) {
                endRoute = true;
                break;
            }
        }

        String result;

        if(foundAllBomb){
            result = "Congratulations! You found all bombs!";
        } else if(endRoute) {
            result = "END! " + bombNumber + " bombs left on the field";
        } else {
            result = String.format("%d bombs left on the field. Sapper position: (%d,%d)", bombNumber, playerPosition[0], playerPosition[1]);
        }

        System.out.println(result);
    }

    public static int fillTheMatrix(String[][] matrix, int[] playerPosition, Scanner console) {
        int bombNumber = 0;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = console.nextLine().split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                    matrix[playerPosition[0]][playerPosition[1]] = "+";
                }
                if (matrix[i][j].equals("B")) {
                    bombNumber++;
                }
            }
        }
        return bombNumber;
    }

    public static boolean PlayerInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] playerPosition, int rowMatrix) {
        switch (command) {
            case "up":
                if (PlayerInTheMatrix(playerPosition[0] - 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]--;
                }
                break;
            case "down":
                if (PlayerInTheMatrix(playerPosition[0] + 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]++;
                }
                break;
            case "left":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] - 1, rowMatrix)) {
                    playerPosition[1]--;
                }
                break;
            case "right":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] + 1, rowMatrix)) {
                    playerPosition[1]++;
                }
                break;
        }
    }
}
