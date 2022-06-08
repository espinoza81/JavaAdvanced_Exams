package aquarium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Aquarium {
    private Map<String, Fish> fishInPool = new HashMap<>();
    private String name;
    private int capacity;
    private int size; // the volume of the pool

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public void add(Fish fish) {
        if (this.fishInPool.size() < this.capacity) {
            this.fishInPool.putIfAbsent(fish.getName(), fish);
        }
    }

    public boolean remove(String name) {
        if (this.fishInPool.containsKey(name)) {
            this.fishInPool.remove(name);
            return true;
        }
        return false;
    }

    public Fish findFish(String name){
        return this.fishInPool.get(name);
    }
    public String report() {
        return "Aquarium: " + this.name + " ^ Size: " + this.size + System.lineSeparator() +
                this.fishInPool.values().stream().map(Fish::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }
}
