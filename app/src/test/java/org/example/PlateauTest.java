package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {

    @Test
    public void testPlateauInitialization() {
        Plateau plateau = new Plateau(5,5);

        assertEquals(5, plateau.getDimX());
        assertEquals(5, plateau.getDimY());
    }

    @Test
    public void testIsWithinBounds() {
        Plateau plateau = new Plateau(5,5);

        assertTrue(plateau.isWithinBounds(3,4));
        assertFalse(plateau.isWithinBounds(6,5));
        assertFalse(plateau.isWithinBounds(5,6));
        assertFalse(plateau.isWithinBounds(-1, 2));
    }
}