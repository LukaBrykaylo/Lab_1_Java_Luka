package ua.lviv.iot.algo.part1.lab4;

import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.lviv.iot.algo.part1.lab4.model.InkjetPrinter;
import ua.lviv.iot.algo.part1.lab4.model.LaserPrinter;
import ua.lviv.iot.algo.part1.lab4.model.MatrixPrinter;
import ua.lviv.iot.algo.part1.lab4.model.Printer;
import ua.lviv.iot.algo.part1.lab4.model.SublimationPrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@ToString(callSuper = true)
public class PrinterManager {
    public final List<Printer> allPrinters = new LinkedList<>();

    public void addPrinter(final Printer printer) {
        this.allPrinters.add(printer);
    }

    public List<Printer> findAllWithPaperCountMoreThan(final int paper) {
        return allPrinters.stream()
                .filter(x -> x.getPaperCount() > paper)
                .collect(Collectors.toList());
    }

    public List<Printer> findAllWithPaperTrayCapacityMoreThan(final int paper) {
        return allPrinters.stream()
                .filter(x -> x.getPaperTrayCapacity() > paper)
                .collect(Collectors.toList());
    }

    @Generated
    public static void main(String[] args) {
        PrinterWriter printerWriter = new PrinterWriter();

        List<Printer> printers = new ArrayList<>();
        printers.add(new SublimationPrinter(400, 0));
        printers.add(new MatrixPrinter(24, true, 100));
        printers.add(new SublimationPrinter(400, 0));
        printers.add(new MatrixPrinter(24, true, 100));
        printers.add(new SublimationPrinter(400, 0));
        printers.add(new MatrixPrinter(24, true, 100));
        printers.add(new InkjetPrinter(250, true));
        printers.add(new LaserPrinter(100, 0));
        printers.add(new InkjetPrinter(300, true));
        printers.add(new LaserPrinter(150, 1));

        printerWriter.writeToFile(printers);

    }
}
