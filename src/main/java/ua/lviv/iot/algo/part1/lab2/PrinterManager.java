package ua.lviv.iot.algo.part1.lab2;

import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.lviv.iot.algo.part1.lab2.model.*;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@ToString
public class PrinterManager {
    private List<Printer> allPrinters = new LinkedList<>();

    public void addPrinter(Printer printer) {
        allPrinters.add(printer);
    }

    public void findAllWithPaperCountMoreThan(int paper) {
        allPrinters.stream()
                .filter(x -> x.getPaperCount() > paper)
                .forEach(x -> System.out.println(x));
    }

    public void findAllWithPaperTrayCapacityMoreThan(int paper) {
        allPrinters.stream()
                .filter(x -> x.getPaperTrayCapacity() > paper)
                .forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) {

        PrinterManager printerManager = new PrinterManager();

        Printer inkjetPrinter = new InkjetPrinter(250, true);
        Printer inkjetPrinter_2 = new InkjetPrinter(200, true);
        inkjetPrinter_2.loadPaper(55);
        Printer laserPrinter = new LaserPrinter(100, 0);
        Printer laserPrinter_2 = new LaserPrinter(50, 0);
        laserPrinter_2.setPaperTrayCapacity(200);
        Printer matrixPrinter = new MatrixPrinter(24, true, 50);
        matrixPrinter.loadPaper(60);
        Printer matrixPrinter_2 = new MatrixPrinter(9, false, 100);
        Printer sublimationPrinter = new SublimationPrinter(40, 0);
        sublimationPrinter.setPaperTrayCapacity(150);
        Printer sublimationPrinter_2 = new SublimationPrinter(60, 0);

        printerManager.addPrinter(inkjetPrinter);
        printerManager.addPrinter(inkjetPrinter_2);
        printerManager.addPrinter(laserPrinter);
        printerManager.addPrinter(laserPrinter_2);
        printerManager.addPrinter(matrixPrinter);
        printerManager.addPrinter(matrixPrinter_2);
        printerManager.addPrinter(sublimationPrinter);
        printerManager.addPrinter(sublimationPrinter_2);

        for (Printer printer : printerManager.allPrinters) {
            System.out.println(printer);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        printerManager.findAllWithPaperCountMoreThan(50);
        System.out.println("-----------------------------------------------------------------------------------");
        printerManager.findAllWithPaperTrayCapacityMoreThan(140);
    }
}
