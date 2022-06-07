package easterBasket;

public class Egg {
    private String color;
    private int strength;
    private String shape;

    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return  this.color + " egg, with " + this.strength + " strength and " + this.shape + " shape.";
    }

    public String getColor() {
        return color;
    }

    public int getStrength() {
        return strength;
    }

}
