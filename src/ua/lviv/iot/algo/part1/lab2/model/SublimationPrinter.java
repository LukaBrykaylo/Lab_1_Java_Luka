package ua.lviv.iot.algo.part1.lab2.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SublimationPrinter extends Printer {
    final int REQUIRED_COLOUR_PER_PAGE = 10;
    int levelOfCMYK = 60;
    int temperature = 0;

    @Override
    public void print(int pages) {
        if (paperCount >= pages && (levelOfCMYK / REQUIRED_COLOUR_PER_PAGE) >= pages) {
            paperCount -= pages;
            levelOfCMYK -= (REQUIRED_COLOUR_PER_PAGE * pages);
        }
    }

    @Override
    public int getRemainingPagesCount() {
        if (paperCount > (levelOfCMYK / REQUIRED_COLOUR_PER_PAGE)) {
            return (levelOfCMYK / REQUIRED_COLOUR_PER_PAGE);
        } else {
            return paperCount;
        }
    }
}
