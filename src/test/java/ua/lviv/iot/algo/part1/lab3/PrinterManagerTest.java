package ua.lviv.iot.algo.part1.lab3;

import junit.framework.TestCase;
import org.junit.Test;
import ua.lviv.iot.algo.part1.lab3.model.InkjetPrinter;
import ua.lviv.iot.algo.part1.lab3.model.LaserPrinter;
import ua.lviv.iot.algo.part1.lab3.model.Printer;

import java.util.List;
import java.util.ArrayList;
public class PrinterManagerTest extends TestCase {

    PrinterManager printerManager = new PrinterManager();

    @Test
    public void testAddPrinter() {
        Printer inkjetPrinter = new InkjetPrinter(250, true);
        Printer laserPrinter = new LaserPrinter(100, 0);
        printerManager.addPrinter(laserPrinter);
        printerManager.addPrinter(inkjetPrinter);

        assertEquals(2, printerManager.getAllPrintersList().size());
    }
    @Test
    public void testFindAllWithPaperCountMoreThan() {
        Printer inkjetPrinter = new InkjetPrinter(250, true);
        inkjetPrinter.loadPaper(2);
        Printer laserPrinter = new LaserPrinter(100, 0);
        laserPrinter.setPaperCount(0);
        printerManager.addPrinter(laserPrinter);
        printerManager.addPrinter(inkjetPrinter);
        List<Printer> expectedList = new ArrayList<>();
        expectedList.add(inkjetPrinter);

        assertEquals(expectedList.toString(), printerManager.findAllWithPaperCountMoreThan(1).toString());
    }
    @Test
    public void testFindAllWithPaperTrayCapacityMoreThan() {
        Printer inkjetPrinter = new InkjetPrinter(250, true);
        inkjetPrinter.setPaperTrayCapacity(100);
        Printer laserPrinter = new LaserPrinter(100, 0);
        laserPrinter.setPaperTrayCapacity(50);
        printerManager.addPrinter(laserPrinter);
        printerManager.addPrinter(inkjetPrinter);
        List<Printer> expectedList = new ArrayList<>();
        expectedList.add(inkjetPrinter);

        assertEquals(expectedList.toString(), printerManager.findAllWithPaperTrayCapacityMoreThan(70).toString());
    }
}