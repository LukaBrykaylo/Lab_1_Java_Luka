package ua.lviv.iot.algo.part1.lab3.model;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class LaserPrinterTest extends TestCase {

    LaserPrinter laserPrinter;

    @BeforeEach
    public final void setUp() {
        laserPrinter = new LaserPrinter(80, 0);
    }

    @Test
    public final void testPrint() {

        laserPrinter.paperCount = 1;
        assertEquals("out of paper", laserPrinter.print(5));
        assertEquals("printed", laserPrinter.print(1));
        laserPrinter.setCapacityOfToner(0);
        laserPrinter.loadPaper(9);
        assertEquals("failed", laserPrinter.print(9));
    }
}