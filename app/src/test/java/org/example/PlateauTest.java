package org.example;

import org.junit.jupiter.api.Test;

public class PlateauTest {

    @Test
    public void testPlateauInitialization() {
        Plateau plateau = new Plateau(5,5);

        assertEquals(5, plateau.getWidth());
        assertEquals(5, plateau.getHeight());
    }
}