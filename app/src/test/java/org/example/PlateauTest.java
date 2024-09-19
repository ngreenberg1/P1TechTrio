package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


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

    @Test
    public void testInvalidPlateauDimensions() {
        // Test invalid dimensions with negative values
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Plateau(-5, 5);
        });
        assertEquals("Dimensions must be positive.", thrown.getMessage());

        // Test invalid dimensions with zero values
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Plateau(0, 5);
        });
        assertEquals("Dimensions must be positive.", thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Plateau(5, 0);
        });
        assertEquals("Dimensions must be positive.", thrown.getMessage());

        // Test invalid dimensions with both negative values
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Plateau(-5, -5);
        });
        assertEquals("Dimensions must be positive.", thrown.getMessage());
    }



}