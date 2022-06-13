package Exams_maps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> tulips = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> daffodils = new ArrayDeque<>(); //stack
        Integer[] tulipsFromConsole = Arrays.stream(console.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] daffodilsFromConsole = Arrays.stream(console.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.stream(tulipsFromConsole).forEach(tulips::push);
        Collections.addAll(daffodils, daffodilsFromConsole);

        int bouquets = 5;
        int storeFlower = 0;

        while (!(daffodils.isEmpty() || tulips.isEmpty()) || bouquets > 5) {
            int singleTulips = tulips.pop();
            int singleDaffodils = daffodils.poll();
            while (true){
                if (singleDaffodils + singleTulips < 15) {
                    storeFlower += singleDaffodils + singleTulips;
                    break;
                } else if (singleDaffodils + singleTulips == 15) {
                    bouquets--;
                    break;
                } else {
                    singleTulips -= 2;
                }
            }
        }
        bouquets -= storeFlower / 15;
        if (bouquets <= 0) {
            System.out.println("You made it! You go to the competition with 5 bouquets!");
        } else {
            System.out.println("You failed... You need more " + bouquets + " bouquets.");
        }
    }
}
