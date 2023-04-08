package ua.lviv.iot.algo.part1.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaserPrinter extends Printer {
    private static final int REQUIRED_CAPACITY_OF_TONER_PAGE = 10;
    private int capacityOfToner = 150;
    private int printedPages = 0;

    @Override
    public String print(final int pages) {
        if (printedPages <= (capacityOfToner / REQUIRED_CAPACITY_OF_TONER_PAGE)) {
            if (paperCount >= pages) {
                paperCount -= pages;
                printedPages += pages;
                capacityOfToner -= 10;
                return "printed";
            }
            return "out of paper";
        } else {
            return "failed";
        }
    }
    public void setCapacityOfToner(final int capacityOfToner) {
        this.capacityOfToner = capacityOfToner;
    }
}