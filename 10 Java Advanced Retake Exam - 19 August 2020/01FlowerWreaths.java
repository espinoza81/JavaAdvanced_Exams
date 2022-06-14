package Exams_maps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> roses = new ArrayDeque<>(); //queue
        Integer[] liliesFromConsole = Arrays.stream(console.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] rosesFromConsole = Arrays.stream(console.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.stream(liliesFromConsole).forEach(lilies::push);
        Collections.addAll(roses, rosesFromConsole);

        int wreaths = 0;
        int storeFlower = 0;

        while (!(lilies.isEmpty() || roses.isEmpty())) {
            int singleLilies = lilies.pop();
            int singleRose = roses.poll();
            while (true){
                if (singleLilies + singleRose < 15) {
                    storeFlower += singleLilies + singleRose;
                    break;
                } else if (singleLilies + singleRose == 15) {
                    wreaths++;
                    break;
                } else {
                    singleLilies -= 2;
                }
            }
        }
        wreaths += storeFlower / 15;
        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5-wreaths) + " wreaths more!");
        }
    }
}
