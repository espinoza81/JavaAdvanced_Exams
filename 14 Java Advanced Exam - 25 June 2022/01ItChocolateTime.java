package Exams_maps;

import java.util.*;
import java.util.stream.Collectors;

public class ItChocolateTime {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Double> milk = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacao = new ArrayDeque<>();

        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacao::push);

        Map<String, Integer> makeChocolate = new TreeMap<>();
        makeChocolate.put("Milk Chocolate", 0);
        makeChocolate.put("Dark Chocolate", 0);
        makeChocolate.put("Baking Chocolate", 0);

        while (!(milk.isEmpty() || cacao.isEmpty())) {
            double singleMilk = milk.poll();
            double singleCacao = cacao.pop();
            double total = singleCacao*100 / (singleMilk + singleCacao);
            switch ((int) total) {
                case 30:
                    makeChocolate.put("Milk Chocolate", makeChocolate.get("Milk Chocolate") + 1);
                    break;
                case 50:
                    makeChocolate.put("Dark Chocolate", makeChocolate.get("Dark Chocolate") + 1);
                    break;
                case 100:
                    makeChocolate.put("Baking Chocolate", makeChocolate.get("Baking Chocolate") + 1);
                    break;
                default:
                    milk.offer(singleMilk + 10);
            }
        }

        if(makeChocolate.values().stream().allMatch(s -> s >= 1)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        makeChocolate.entrySet().stream().filter(s -> s.getValue() >= 1)
                .forEach(s -> System.out.printf(" # %s --> %d%n", s.getKey(), s.getValue()));
    }
}
