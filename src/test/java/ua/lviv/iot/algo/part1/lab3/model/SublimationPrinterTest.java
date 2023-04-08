package ua.lviv.iot.algo.part1.lab3.model;

import junit.framework.TestCase;
import org.junit.Test;

public class SublimationPrinterTest extends TestCase {

    SublimationPrinter sublimationPrinter = new SublimationPrinter(70, 30);
    SublimationPrinter testSublimationPrinter = new SublimationPrinter();
    @Test
    public void testPrint() {
        sublimationPrinter.paperCount = 25;
        assertEquals("failed", sublimationPrinter.print(50));
        assertEquals("printed", sublimationPrinter.print(5));
    }

    @Test
    public void testGetRemainingPagesCount() {
        sublimationPrinter.paperCount = 10;
        assertEquals(7, sublimationPrinter.getRemainingPagesCount());
        sublimationPrinter.paperCount = 1;
        assertEquals(1, sublimationPrinter.getRemainingPagesCount());
    }
}