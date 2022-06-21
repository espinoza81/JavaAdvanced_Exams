package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data = new ArrayList<>();

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Parrot parrot) {
        if(this.data.size() < this.capacity) {
            this. data.add(parrot);
        }
    }
    public boolean remove(String name) {
        return this.data.removeIf(s -> s.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream().filter(s -> s.getName().equals(name)).findAny().orElse(null);
        if (parrot != null) {
            parrot.setAvailable(false);
        }
        return parrot;
    }
    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();
        this.data.stream().filter(s -> s.getSpecies().equals(species)).forEach(s-> {
            parrots.add(s);
            s.setAvailable(false);
        });
        return parrots;
    }

    public int count(){
        return this.data.size();
    }
    public String report(){
        return "Parrots available at " + this.name + ":" + System.lineSeparator() +
                this.data.stream().filter(Parrot::isAvailable).map(Parrot::toString).collect(Collectors.joining(System.lineSeparator()));
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
