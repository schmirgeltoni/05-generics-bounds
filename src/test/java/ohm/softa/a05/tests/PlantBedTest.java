package ohm.softa.a05.tests;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlantBedTest {

    private static final PlantBed<Plant> bed = new PlantBed<>();
    static Plant redFlower = new Flower(0.3, "f", "n", PlantColor.RED);

    @BeforeAll
    static void setup() {
        bed.add(redFlower);
        bed.add(new Flower(0.3, "f", "n", PlantColor.YELLOW));
        bed.add(new Flower(0.3, "f", "n", PlantColor.BLUE));
        bed.add(new Shrub(0.3, "f", "n"));
        bed.add(new Shrub(0.3, "f", "n"));
    }

    @Test
    void TestPlantBedAddAndSize() {
        assertEquals(5, bed.size());
    }

    @Test
    void TestGetPlantsByColor() {
        SimpleList<Plant> filteredList = bed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(2, filteredList.size());
    }

    @Test
    void PlantBedRemove(){
        Plant removedFlower = bed.remove(redFlower);
        assertEquals(4, bed.size());
        assert(removedFlower.equals(redFlower));
        assertThrows(RuntimeException.class, () -> {
           bed.remove(redFlower);
        });
    }
}
