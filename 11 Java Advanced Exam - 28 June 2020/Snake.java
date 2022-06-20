package Exams_matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Snake {

    private static int rowMatrix = 0;
    private static int snakeRow = -1;
    private static int snakeCol = -1;
    private static int burrowsRow = 0;
    private static String command = null;
    private static int foodEaten = 0;
    private static boolean isOut = false;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        rowMatrix = Integer.parseInt(console.nextLine());
        char[][] matrix = new char[rowMatrix][rowMatrix];
        int[][] burrowsCoordinates = new int[2][2];


        fillMatrix(matrix, console, burrowsCoordinates);

        while (foodEaten < 10) {
            command = console.nextLine();
            matrix[snakeRow][snakeCol] = '.';
            move();
            if (isOut) break;
            if (matrix[snakeRow][snakeCol] == '*') {
                foodEaten++;
            }
            if (matrix[snakeRow][snakeCol] == 'B') {
                matrix[snakeRow][snakeCol] = '.';
                if (snakeRow == burrowsCoordinates[0][0] && snakeCol == burrowsCoordinates[0][1]) {
                    snakeRow = burrowsCoordinates[1][0];
                    snakeCol = burrowsCoordinates[1][1];
                } else {
                    snakeRow = burrowsCoordinates[0][0];
                    snakeCol = burrowsCoordinates[0][1];
                }
            }
        }

        if (isOut) {
            System.out.println("Game over!");
        } else {
            matrix[snakeRow][snakeCol] = 'S';
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + foodEaten);
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    private static void fillMatrix(char[][] matrix, Scanner console, int[][] burrowsCoordinates) {
        for (int i = 0; i < rowMatrix; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
                if (input.charAt(j) == 'B') {
                    burrowsCoordinates[burrowsRow][0] = i;
                    burrowsCoordinates[burrowsRow][1] = j;
                    burrowsRow++;
                }
            }
        }
    }

    public static boolean SnakeInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move() {
        switch (command) {
            case "up":
                if (SnakeInTheMatrix(snakeRow - 1, snakeCol, rowMatrix)) {
                    snakeRow--;
                } else {
                    isOut = true;
                }
                break;
            case "down":
                if (SnakeInTheMatrix(snakeRow + 1, snakeCol, rowMatrix)) {
                    snakeRow++;
                } else {
                    isOut = true;
                }
                break;
            case "left":
                if (SnakeInTheMatrix(snakeRow, snakeCol - 1, rowMatrix)) {
                    snakeCol--;
                } else {
                    isOut = true;
                }
                break;
            case "right":
                if (SnakeInTheMatrix(snakeRow, snakeCol + 1, rowMatrix)) {
                    snakeCol++;
                } else {
                    isOut = true;
                }
                break;
        }
    }
}
