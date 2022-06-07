package Exams;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<String> vowels = new ArrayDeque<>(); //queue
        ArrayDeque<String> consonants = new ArrayDeque<>(); //stack
        String[] vowel = console.nextLine().split("\\s+");
        String[] consonant = console.nextLine().split("\\s+");
        Collections.addAll(vowels, vowel);
        Arrays.stream(consonant).forEach(consonants::push);
        Set<String> pear = new HashSet<>();
        Set<String> flour = new HashSet<>();
        Set<String> pork = new HashSet<>();
        Set<String> olive = new HashSet<>();
        List<String> foundWord = new ArrayList<>();

        while (!consonants.isEmpty()) {
            String singleVowel = vowels.poll();
            String singleConsonant = consonants.pop();
            if("pear".contains(Objects.requireNonNull(singleVowel))) pear.add(singleVowel);
            if("pear".contains(Objects.requireNonNull(singleConsonant))) pear.add(singleConsonant);
            if("flour".contains(Objects.requireNonNull(singleVowel))) flour.add(singleVowel);
            if("flour".contains(Objects.requireNonNull(singleConsonant))) flour.add(singleConsonant);
            if("pork".contains(Objects.requireNonNull(singleVowel))) pork.add(singleVowel);
            if("pork".contains(Objects.requireNonNull(singleConsonant))) pork.add(singleConsonant);
            if("olive".contains(Objects.requireNonNull(singleVowel))) olive.add(singleVowel);
            if("olive".contains(Objects.requireNonNull(singleConsonant))) olive.add(singleConsonant);
            vowels.offer(singleVowel);
        }
        if(pear.size()==4) foundWord.add("pear");
        if(flour.size()==5) foundWord.add("flour");
        if(pork.size()==4) foundWord.add("pork");
        if(olive.size()==5) foundWord.add("olive");

        System.out.println("Words found: " + foundWord.size());
        System.out.println(String.join(System.lineSeparator(), foundWord));

    }
}
