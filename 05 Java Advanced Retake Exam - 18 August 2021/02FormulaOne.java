package Exams_matrix;

import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowMatrix = Integer.parseInt(console.nextLine());
        int countCommands = Integer.parseInt(console.nextLine());
        char[][] matrix = new char[rowMatrix][rowMatrix];
        int[] playerPosition = new int[2];
        int[] oldPosition = new int[2];


        for (int i = 0; i < rowMatrix; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'P') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }

        boolean finished = false;
        while (countCommands-- > 0) {
            String command = console.nextLine();
            oldPosition[0]=playerPosition[0];
            oldPosition[1]=playerPosition[1];
            matrix[playerPosition[0]][playerPosition[1]] = '.';
            move(command, playerPosition, rowMatrix);
            if (matrix[playerPosition[0]][playerPosition[1]] == 'B') {
                move(command, playerPosition, rowMatrix);
            }
            if (matrix[playerPosition[0]][playerPosition[1]] == 'T') {
                playerPosition[0] = oldPosition[0];
                playerPosition[1] = oldPosition[1];
            }
            if (matrix[playerPosition[0]][playerPosition[1]] == 'F') {
                matrix[playerPosition[0]][playerPosition[1]] = 'P';
                finished = true;
                break;
            }
            matrix[playerPosition[0]][playerPosition[1]] = 'P';
        }

        if(finished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static boolean PlayerInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] playerPosition, int rowMatrix){
        switch (command) {
            case "up":
                if (PlayerInTheMatrix(playerPosition[0] - 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]--;
                } else {
                    playerPosition[0] = rowMatrix-1;
                }
                break;
            case "down":
                if (PlayerInTheMatrix(playerPosition[0] + 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]++;
                } else {
                    playerPosition[0] = 0;
                }
                break;
            case "left":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] - 1, rowMatrix)) {
                    playerPosition[1]--;
                } else {
                    playerPosition[1] = rowMatrix-1;
                }
                break;
            case "right":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] + 1, rowMatrix)) {
                    playerPosition[1]++;
                } else {
                    playerPosition[1] = 0;
                }
                break;
        }
    }
}
