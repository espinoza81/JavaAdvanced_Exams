package Exams_maps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Integer[] tasksFromConsole = Arrays.stream(console.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] threadsFromConsole = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.stream(tasksFromConsole).forEach(tasks::push);
        Collections.addAll(threads, threadsFromConsole);
        int taskToKill = Integer.parseInt(console.nextLine());

        while (true){
            if(tasks.peek()==taskToKill){
                System.out.println("Thread with value " + threads.peek() + " killed task " + taskToKill);
                break;
            } else if(threads.peek() >= tasks.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }
        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
