package ua.lviv.iot.algo.part1.lab3;

import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.lviv.iot.algo.part1.lab3.model.Printer;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@ToString(callSuper = true)
public class PrinterManager {
    private List<Printer> allPrinters = new LinkedList<>();

    public void addPrinter(final Printer printer) {
        this.allPrinters.add(printer);
    }

    public List<Printer> getAllPrintersList() {
        return this.allPrinters;
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
}
