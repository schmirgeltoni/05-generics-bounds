package ohm.softa.a05.tests;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("SpellCheckingInspection")
public class PlantTest {

    private final Plant rose = new Flower(0.3, "Rosaceae", "Red Rose", PlantColor.RED);
    private final Plant hydrangea = new Flower(0.2, "Hydrangeaceae", "Hydrangea", PlantColor.BLUE);

    @Test
    void TestPlantCompare() {
        assert (rose.compareTo(hydrangea) > 0);
        assert (hydrangea.compareTo(rose) < 0);
        Plant tallerHydrangea = new Flower(0.3, "Hydrangeaceae", "Hydrangea", PlantColor.BLUE);
        assert (rose.compareTo(tallerHydrangea) == 0);
    }

    @Test
    void TestPlantEquals() {
        Plant yellowRose = new Flower(0.3, "Rosaceae", "White Rose", PlantColor.YELLOW);
        assert (!rose.equals(yellowRose));
        Plant identicalRedRose = new Flower(0.3, "Rosaceae", "Red Rose", PlantColor.RED);
        assert (rose.equals(identicalRedRose));
    }

    @Test
    void TestExceptionForGreenFlowers() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(0.0, "f", "n", PlantColor.GREEN));
    }

    @Test
    void TestExceptionForNonGreenShrubs() {
        assertThrows(IllegalArgumentException.class, () -> new Shrub(0.0, "f", "n", PlantColor.YELLOW));
    }

    @Test
    void TestGetters(){
        assertEquals(PlantColor.RED, rose.getColor());
        assertEquals("Rosaceae", rose.getFamily());
        assertEquals(0.3, rose.getHeight());
        assertEquals("Red Rose", rose.getName());
    }
}
