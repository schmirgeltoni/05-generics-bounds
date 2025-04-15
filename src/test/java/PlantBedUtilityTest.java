import ohm.softa.a05.model.*;
import ohm.softa.a05.utils.PlantBedUtility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantBedUtilityTest {

    private static PlantBed<Plant> mixedBed;
    private static PlantBed<Flower> flowerBed;
    private static PlantBed<Shrub> shrubBed;

    private static final Flower redFlower = new Flower(0.3, "f", "n", PlantColor.RED);
    private static final Flower yellowFlower = new Flower(0.3, "f", "n", PlantColor.YELLOW);
    private static final Flower blueFlower = new Flower(0.3, "f", "n", PlantColor.BLUE);
    private static final Flower orangeFlower = new Flower(0.3, "f", "n", PlantColor.ORANGE);

    private static final Shrub shrub1 = new Shrub(0.2, "f", "n");
    private static final Shrub shrub2 = new Shrub(0.4, "f", "n");

    @BeforeEach
    void resetAndPopulateBeds() {
        mixedBed = new PlantBed<>();
        flowerBed = new PlantBed<>();
        shrubBed = new PlantBed<>();

        mixedBed.add(redFlower);
        mixedBed.add(yellowFlower);
        mixedBed.add(blueFlower);
        mixedBed.add(orangeFlower);
        mixedBed.add(shrub1);
        mixedBed.add(shrub2);

        flowerBed.add(redFlower);
        flowerBed.add(yellowFlower);
        flowerBed.add(blueFlower);
        flowerBed.add(orangeFlower);

        shrubBed.add(shrub1);
        shrubBed.add(shrub2);
    }

    @Test
    void TestSimpleRepot() {
        PlantBed<Plant> to = new PlantBed<>();
        PlantBedUtility.repot(mixedBed, PlantColor.GREEN, to);
        assertEquals(2, to.size());
        assertEquals(4, mixedBed.size());
    }

    @Test
    void RepotFromFlowerToPlantBed() {
        PlantBedUtility.repot(flowerBed, PlantColor.ORANGE, mixedBed);
        assertEquals(3, flowerBed.size());
        assertEquals(7, mixedBed.size());
    }

    @Test
    void RepotFromShrubToPlantBed() {
        PlantBedUtility.repot(shrubBed, PlantColor.GREEN, mixedBed);
        assertEquals(0, shrubBed.size());
        assertEquals(8, mixedBed.size());
    }
}
