package ua.lviv.iot.algo.part1.lab2.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaserPrinter extends Printer {
    int capacityOfToner = 150;
    int printedPages = 0;

    @Override
    public void print(int pages) {
        if (printedPages <= capacityOfToner) {
            if (paperCount >= pages) {
                paperCount -= pages;
                printedPages += pages;
            }
        }
    }
}