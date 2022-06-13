package Exams_matrix;

import java.util.Arrays;
import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowMatrix = Integer.parseInt(console.nextLine());
        char[][] matrix = new char[rowMatrix][rowMatrix];
        int[] playerPosition = new int[2];
        int[][] pillarsCoordinates = new int[2][2];
        fillTheMatrix(matrix, playerPosition, console, pillarsCoordinates);
        int money = 0;

        int[] outOfPastry  = new int[1];

        while (money < 50) {
            String command = console.nextLine();
            matrix[playerPosition[0]][playerPosition[1]] = '-';
            move(command, playerPosition, rowMatrix, outOfPastry);
            if (outOfPastry[0] == 1) {
                break;
            }
            if (String.valueOf(matrix[playerPosition[0]][playerPosition[1]]).matches("\\d")) {
                money += Integer.parseInt(String.valueOf(matrix[playerPosition[0]][playerPosition[1]]));
            }
            if (matrix[playerPosition[0]][playerPosition[1]] == 'P') {
                matrix[playerPosition[0]][playerPosition[1]] = '-';
                if(playerPosition[0] == pillarsCoordinates[0][0] && playerPosition[1] == pillarsCoordinates[0][1]){
                    playerPosition[0]= pillarsCoordinates[1][0];
                    playerPosition[1]= pillarsCoordinates[1][1];
                } else {
                    playerPosition[0]= pillarsCoordinates[0][0];
                    playerPosition[1]= pillarsCoordinates[0][1];
                }
            }
            matrix[playerPosition[0]][playerPosition[1]] = 'S';
        }
        if(outOfPastry[0] == 1){
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static void fillTheMatrix(char[][] matrix, int[] playerPosition, Scanner console, int[][] pillarsCoordinates){
        int pillarRow=0;
        for (int i = 0; i < matrix.length; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'S') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
                if (input.charAt(j) == 'P') {
                    pillarsCoordinates[pillarRow][0] = i;
                    pillarsCoordinates[pillarRow][1] = j;
                    pillarRow++;
                }
            }
        }
    }

    public static boolean PlayerInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] playerPosition, int rowMatrix, int[] outOfPastry){
        switch (command) {
            case "up":
                if (PlayerInTheMatrix(playerPosition[0] - 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]--;
                } else {
                    outOfPastry[0] = 1;
                }
                break;
            case "down":
                if (PlayerInTheMatrix(playerPosition[0] + 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]++;
                } else {
                    outOfPastry[0] = 1;
                }
                break;
            case "left":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] - 1, rowMatrix)) {
                    playerPosition[1]--;
                } else {
                    outOfPastry[0] = 1;
                }
                break;
            case "right":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] + 1, rowMatrix)) {
                    playerPosition[1]++;
                } else {
                    outOfPastry[0] = 1;
                }
                break;
        }
    }
}
