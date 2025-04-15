package ohm.softa.a05.model;

public class Shrub extends Plant {

    public Shrub(double height, String family, String name) {
        this.height = height;
        this.family = family;
        this.name = name;
    }

    @Override
    public PlantColor getColor() {
        return PlantColor.GREEN;
    }
}
