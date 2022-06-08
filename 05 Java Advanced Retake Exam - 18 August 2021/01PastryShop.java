package Exams_maps;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(); //stack
        Integer[] liquidsFromConsole = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] ingredientsFromConsole = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(liquids, liquidsFromConsole);
        Arrays.stream(ingredientsFromConsole).forEach(ingredients::push);

        Map<Integer, String> needResourcesForFood = new HashMap<>();
        needResourcesForFood.put(25, "Biscuit");
        needResourcesForFood.put(50, "Cake");
        needResourcesForFood.put(75, "Pastry");
        needResourcesForFood.put(100, "Pie");
        Map<String, Integer> makeFood = new TreeMap<>();

        while (!(ingredients.isEmpty() || liquids.isEmpty())) {
            int singleLiquids = liquids.poll();
            int singleIngredients = ingredients.pop();
            int totalIngredients = singleLiquids + singleIngredients;
            if (needResourcesForFood.containsKey(totalIngredients)) {
                String food = needResourcesForFood.get(totalIngredients);
                makeFood.putIfAbsent(food, 0);
                makeFood.put(food, makeFood.get(food) + 1);
            } else {
                ingredients.push(singleIngredients + 3);
            }
        }

        String result;

        if (makeFood.size() == 4) {
            result = "Great! You succeeded in cooking all the food!";
        } else {
            result = "What a pity! You didn't have enough materials to cook everything.";
        }
        System.out.println(result);

        if (liquids.isEmpty()) {
            result = "Liquids left: none";
        } else {
            result = String.format("Liquids left: %s", liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        if (ingredients.isEmpty()) {
            result = "Ingredients left: none";
        } else {
            result = String.format("Ingredients left: %s", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        System.out.println("Biscuit: " + (makeFood.getOrDefault("Biscuit", 0)));
        System.out.println("Cake: " + (makeFood.getOrDefault("Cake", 0)));
        System.out.println("Pie: " + (makeFood.getOrDefault("Pie", 0)));
        System.out.println("Pastry: " + (makeFood.getOrDefault("Pastry", 0)));
    }
}
