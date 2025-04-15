package ohm.softa.a05.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

abstract public class Plant implements Comparable<Plant> {
    protected double height;
    protected String family;
    protected String name;
    protected PlantColor color;

    @Override
    public int compareTo(Plant o) {
        return Double.compare(this.height, o.height);
    }

    public double getHeight() {
        return height;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public PlantColor getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plant) {
            var o = (Plant) obj;
            return o.height == height && o.color == color && Objects.equals(o.family, family) && Objects.equals(o.name, name);
        } else
            return false;
    }

    @Override
    public String toString() {
        return name + ", " + family + ". Height: " + height + ". Color: " + color;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
                append(family).
                append(name).
                append(height).
                toHashCode();
    }
}
