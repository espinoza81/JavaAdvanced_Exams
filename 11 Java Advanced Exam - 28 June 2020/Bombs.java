package Exams_maps;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> effects = Arrays.stream(console.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casings = new ArrayDeque<>();

        Arrays.stream(console.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(casings::push);

        //•	Datura Bombs: 40
        //•	Cherry Bombs: 60
        //•	Smoke Decoy Bombs: 120
        Map<String, Integer> makeBombs = new TreeMap<>();
        makeBombs.put("Datura Bombs", 0);
        makeBombs.put("Cherry Bombs", 0);
        makeBombs.put("Smoke Decoy Bombs", 0);

        boolean makeAllBombs = false;

        while (!(effects.isEmpty() || casings.isEmpty() || makeAllBombs)) {
            int singleEffects = effects.peek();
            int singleCasings = casings.pop();
            int totalMaterial  = singleEffects + singleCasings;
            switch (totalMaterial){
                case 40:
                    makeBombs.put("Datura Bombs", makeBombs.get("Datura Bombs")+1);
                    effects.poll();
                    break;
                case 60:
                    makeBombs.put("Cherry Bombs", makeBombs.get("Cherry Bombs")+1);
                    effects.poll();
                    break;
                case 120:
                    makeBombs.put("Smoke Decoy Bombs", makeBombs.get("Smoke Decoy Bombs")+1);
                    effects.poll();
                    break;
                default:
                    casings.push(singleCasings - 5);
            }
            makeAllBombs=isMaked(makeBombs);
//            if(makeAllBombs) break;

        }

        if(makeAllBombs) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        String remainingEffects = effects.isEmpty() ? "empty" : effects.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Effects: " + remainingEffects);

        String remainingCasings = casings.isEmpty() ? "empty" : casings.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Casings: " + remainingCasings);

        makeBombs.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static boolean isMaked(Map<String, Integer> makeBombs) {
        return makeBombs.values().stream().filter(s -> s >= 3).count()==3;
    }
}
