package ua.lviv.iot.algo.part1.lab3.model;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class SublimationPrinterTest extends TestCase {

    SublimationPrinter sublimationPrinter;

    @BeforeEach
    public final void setUp() {
        sublimationPrinter = new SublimationPrinter(70, 30);
    }

    @Test
    public final void testPrint() {
        sublimationPrinter.paperCount = 25;
        assertEquals("failed", sublimationPrinter.print(50));
        assertEquals("printed", sublimationPrinter.print(5));
    }

    @Test
    public final void testGetRemainingPagesCount() {
        sublimationPrinter.paperCount = 10;
        assertEquals(7, sublimationPrinter.getRemainingPagesCount());
        sublimationPrinter.paperCount = 1;
        assertEquals(1, sublimationPrinter.getRemainingPagesCount());
    }
}