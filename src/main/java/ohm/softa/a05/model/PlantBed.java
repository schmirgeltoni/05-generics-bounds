package ohm.softa.a05.model;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;

public class PlantBed<T extends Plant> {
    private SimpleList<T> plants = new SimpleListImpl<>();

    public void add(T plant) {
        plants.add(plant);
    }

    public int size() {
        return plants.size();
    }

    public SimpleList<T> getPlantsByColor(PlantColor color) {
        return plants.filter(item -> item.getColor() == color);
    }

    public T remove(T plant) {
        int oldSize = size();
        plants = plants.filter(item -> !item.equals(plant));
        if (oldSize == size())
            throw new RuntimeException("Plant was not found in PlantBed");
        return plant;
    }
}
