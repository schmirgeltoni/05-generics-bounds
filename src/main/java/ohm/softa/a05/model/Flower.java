package ohm.softa.a05.model;

public class Flower extends Plant {
    public Flower(double height, String family, String name, PlantColor color) {
        if (color == PlantColor.GREEN)
            throw new IllegalArgumentException("A flower can not be green!");

        this.height = height;
        this.family = family;
        this.name = name;
        this.color = color;
    }
}
