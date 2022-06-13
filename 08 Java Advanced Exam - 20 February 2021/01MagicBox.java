package Exams_maps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> secondBox = new ArrayDeque<>(); //stack
        Integer[] firstsFromConsole = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] secondFromConsole = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(firstBox, firstsFromConsole);
        Arrays.stream(secondFromConsole).forEach(secondBox::push);

        int claimedItems = 0;
        while (!(firstBox.isEmpty() || secondBox.isEmpty())) {
            if((firstBox.peek() + secondBox.peek()) % 2 == 0) {
                claimedItems += firstBox.poll() + secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }
        if(firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if(claimedItems >= 90){
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }
}
