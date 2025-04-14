package ohm.softa.a05.model;

public class Shrub extends Plant {

    public Shrub(double height, String family, String name, PlantColor color) {
        if (color != PlantColor.GREEN)
            throw new IllegalArgumentException("A shrub must be green!");

        this.height = height;
        this.family = family;
        this.name = name;
        this.color = color;

    }
}
