package Exams_matrix;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowMatrix = Integer.parseInt(console.nextLine());
        String[] commands = console.nextLine().split(",\\s+");
        String[][] matrix = new String[rowMatrix][rowMatrix];
        int[] pitonPosition = new int[3];

        fillMatrix(console, rowMatrix, matrix, pitonPosition);

        int pitonLength = 1;
        boolean isDead = false;
        
        for (String command : commands) {
            move(command, pitonPosition, rowMatrix);
            if(matrix[pitonPosition[0]][pitonPosition[1]].equals("f")){
                pitonLength++;
                pitonPosition[2]--;
            }
            if(matrix[pitonPosition[0]][pitonPosition[1]].equals("e")){
                isDead = true;
                break;
            }
        }
        
        String result = null;
        if(pitonPosition[2]==0) {
            result = "You win! Final python length is " + pitonLength;
        } else if(isDead) {
            result = "You lose! Killed by an enemy!";
        } else {
            result = "You lose! There is still " + pitonPosition[2] + " food to be eaten.";
        }
        System.out.println(result);
        
    }

    private static void fillMatrix(Scanner console, int rowMatrix, String[][] matrix, int[] pitonPosition) {
        for (int i = 0; i < rowMatrix; i++) {
            String input = console.nextLine();
            matrix[i] = input.split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    matrix[i][j] = "*";
                    pitonPosition[0] = i;
                    pitonPosition[1] = j;
                }
                if (matrix[i][j].equals("f")) {
                    pitonPosition[2]++;
                }
            }
        }
    }

    public static boolean PitonInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] pitonPosition, int rowMatrix) {
        switch (command) {
            case "up":
                if (PitonInTheMatrix(pitonPosition[0] - 1, pitonPosition[1], rowMatrix)) {
                    pitonPosition[0]--;
                } else {
                    pitonPosition[0] = rowMatrix - 1;
                }
                break;
            case "down":
                if (PitonInTheMatrix(pitonPosition[0] + 1, pitonPosition[1], rowMatrix)) {
                    pitonPosition[0]++;
                } else {
                    pitonPosition[0] = 0;
                }
                break;
            case "left":
                if (PitonInTheMatrix(pitonPosition[0], pitonPosition[1] - 1, rowMatrix)) {
                    pitonPosition[1]--;
                } else {
                    pitonPosition[1] = rowMatrix - 1;
                }
                break;
            case "right":
                if (PitonInTheMatrix(pitonPosition[0], pitonPosition[1] + 1, rowMatrix)) {
                    pitonPosition[1]++;
                } else {
                    pitonPosition[1] = 0;
                }
                break;
        }
    }
}
