package hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown = "n/a";

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Person(String name, int id, int age, String hometown) {
        this(name, id, age);
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "Person " + name + ": " + id + ", Age: " + age + ", Hometown: " + hometown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
