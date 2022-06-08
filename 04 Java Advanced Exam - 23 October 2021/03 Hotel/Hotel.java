package hotel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person peopleToRemove = this.roster.stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
        if (peopleToRemove!=null) {
            this.roster.remove(peopleToRemove);
            return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        Person peopleToFind = this.roster.stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
        if(peopleToFind!=null){
            if(peopleToFind.getHometown().equals(hometown)){
                return peopleToFind;
            }
        }
        return null;
    }

    public String getStatistics() {
        return "The people in the hotel " + this.name + " are:" + System.lineSeparator() +
                this.roster.stream().map(Person::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return this.roster.size();
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
