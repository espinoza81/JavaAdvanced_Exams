package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int energyParis = Integer.parseInt(console.nextLine());
        int rowMatrix = Integer.parseInt(console.nextLine());
        char[][] matrix = new char[rowMatrix][rowMatrix];

        int rowParis = -1;
        int colParis = -1;

        boolean abductedHelen = false;

        for (int i = 0; i < rowMatrix; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'P') {
                    rowParis = i;
                    colParis = j;
                }
            }
        }

        while (true) {
            matrix[rowParis][colParis] = '-';
            String[] tokens = console.nextLine().split("\\s+");
            matrix[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[2])] = 'S';
            energyParis--;
            switch (tokens[0]) {
                case "up":
                    if(parisInTheMatrix(rowParis-1, colParis, rowMatrix)) {
                    rowParis--;
                    }
                    break;
                case "down":
                    if(parisInTheMatrix(rowParis+1, colParis, rowMatrix)) {
                        rowParis++;
                    }
                    break;
                case "left":
                    if(parisInTheMatrix(rowParis, colParis-1, rowMatrix)) {
                        colParis--;
                    }
                    break;
                case "right":
                    if(parisInTheMatrix(rowParis, colParis+1, rowMatrix)) {
                        colParis++;
                    }
                    break;
            }
            if (matrix[rowParis][colParis]=='H'){
                    abductedHelen = true;
                    matrix[rowParis][colParis] = '-';
                break;
            }
            if(matrix[rowParis][colParis]=='S'){
                energyParis -= 2;
            }
            if (energyParis <=0)  {
                matrix[rowParis][colParis] = 'X';
                break;
            }
            matrix[rowParis][colParis] = 'P';
        }

        if(abductedHelen) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energyParis);
        } else {
            System.out.printf("Paris died at %d;%d.%n", rowParis, colParis);
        }
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static boolean parisInTheMatrix(int row, int col, int rowMatrix){
        return row>=0 && row<rowMatrix && col>=0 && col<rowMatrix;
    }
}
