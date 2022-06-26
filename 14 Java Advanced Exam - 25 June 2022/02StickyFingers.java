package Exams_matrix;

import java.util.Scanner;

public class StickyFingers {
    private static int rowMatrix = 0;
    private static int rowDillinger = -1;
    private static int colDillinger = -1;
    private static String command = null;
    private static char[][] matrix = null;
    private static int robHouse = 0; //stolen money
    private static boolean notCaught = true;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        rowMatrix = Integer.parseInt(console.nextLine());
        String[] commandsFromConsole = console.nextLine().split(",");

        fillMatrix(console);

        for (String com : commandsFromConsole) {
            command = com;
            moveDillinger();
            if (caughtInNextCell()) {
                break;
            }
        }

        if (notCaught) {
            matrix[rowDillinger][colDillinger] = 'D';
            System.out.println("Your last theft has finished successfully with " + robHouse + "$ in your pocket.");
        }

        printTheMatrix();
    }

    private static void printTheMatrix() {
        StringBuilder sb = new StringBuilder();
        
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                sb.append(aChar).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        
        System.out.println(sb.toString().trim());
    }

    private static boolean caughtInNextCell() { //what found on the next Cell
        if (matrix[rowDillinger][colDillinger] == '$') {
            matrix[rowDillinger][colDillinger] = '+';
            int stolenMoney = rowDillinger * colDillinger;
            robHouse += stolenMoney;
            System.out.println("You successfully stole " + stolenMoney + "$.");
        }
        
        if (matrix[rowDillinger][colDillinger] == 'P') {
            System.out.println("You got caught with " + robHouse + "$, and you are going to jail.");
            matrix[rowDillinger][colDillinger] = '#';
            notCaught = false;
            return true;
        }
        
        return false;
    }

    private static void fillMatrix(Scanner console) {
        matrix = new char[rowMatrix][rowMatrix];
        
        for (int i = 0; i < rowMatrix; i++) {
            String input = console.nextLine().replaceAll(" ", "");
            matrix[i] = input.toCharArray();
            if (input.contains("D")) {
                rowDillinger = i;
                colDillinger = input.indexOf("D");
                matrix[rowDillinger][colDillinger] = '+';
            }
        }
    }

    public static boolean DillingerInTheMatrix(int rowMutator, int colMutator, int rowMatrix) {
        return rowDillinger + rowMutator >= 0 && rowDillinger + rowMutator < rowMatrix && colDillinger + colMutator >= 0 && colDillinger + colMutator < rowMatrix;
    }

    public static void moveDillinger() {
        String out = "You cannot leave the town, there is police outside!";
        
        switch (command) {
            case "up":
                if (DillingerInTheMatrix(-1, 0, rowMatrix)) {
                    rowDillinger--;
                } else {
                    System.out.println(out);
                }
                break;
            case "down":
                if (DillingerInTheMatrix(1, 0, rowMatrix)) {
                    rowDillinger++;
                } else {
                    System.out.println(out);
                }
                break;
            case "left":
                if (DillingerInTheMatrix(0, -1, rowMatrix)) {
                    colDillinger--;
                } else {
                    System.out.println(out);
                }
                break;
            case "right":
                if (DillingerInTheMatrix(0, 1, rowMatrix)) {
                    colDillinger++;
                } else {
                    System.out.println(out);
                }
                break;
        }
    }
}
