package ua.lviv.iot.algo.part1.lab4;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.algo.part1.lab4.model.InkjetPrinter;
import ua.lviv.iot.algo.part1.lab4.model.LaserPrinter;
import ua.lviv.iot.algo.part1.lab4.model.Printer;

import java.util.List;

public class PrinterManagerTest extends TestCase {

    private PrinterManager printerManager;

    @BeforeEach
    public final void setUp() {
        printerManager = new PrinterManager();
        printerManager.addPrinter(new InkjetPrinter(250, true));
        printerManager.addPrinter(new LaserPrinter(100, 0));
        printerManager.addPrinter(new InkjetPrinter(300, true));
        printerManager.addPrinter(new LaserPrinter(150, 1));
    }

    @Test
    public final void testFindAllWithPaperCountMoreThan() {
        Printer inkjetPrinter = new InkjetPrinter(250, true);
        inkjetPrinter.setPaperCount(50);
        printerManager.addPrinter(inkjetPrinter);

        List<Printer> results = printerManager.findAllWithPaperCountMoreThan(40);
        assertEquals(1, results.size());
        for (var printer : results) {
            assertTrue(printer.getPaperCount() > 40);

        }
    }

    @Test
    public final void testFindAllWithPaperTrayCapacityMoreThan() {
        Printer inkjetPrinter = new InkjetPrinter(250, true);
        inkjetPrinter.setPaperTrayCapacity(120);
        Printer laserPrinter = new LaserPrinter(100, 0);
        laserPrinter.setPaperTrayCapacity(130);
        printerManager.addPrinter(laserPrinter);
        printerManager.addPrinter(inkjetPrinter);

        List<Printer> results = printerManager.findAllWithPaperTrayCapacityMoreThan(119);
        assertEquals(2, results.size());
        for (Printer printer : results) {
            assertTrue(printer.getPaperTrayCapacity() > 119);
        }
    }
}