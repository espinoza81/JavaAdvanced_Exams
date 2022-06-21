package Exams_maps;

import java.util.*;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int collection = 0;

        while (!(secondBox.isEmpty() || firstBox.isEmpty())) {

            int fromSecond = secondBox.pop();

            int total = firstBox.peek() + fromSecond;

            if (total % 2 == 0) {
                firstBox.poll();
                collection += total;
            } else {
                firstBox.offer(fromSecond);
            }
        }

        String result = " lootbox is empty";
        if (firstBox.isEmpty()) {
            System.out.println("First" + result);
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second" + result);
        }

        String kind;
        if (collection >= 100) {
            kind = "epic!";
        } else {
            kind = "poor...";
        }
        System.out.println("Your loot was " + kind + " Value: " + collection);
    }
}
