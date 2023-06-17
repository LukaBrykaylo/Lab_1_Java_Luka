package ua.lviv.iot.algo.part1.lab2.model;

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
public class InkjetPrinter extends Printer {
    final int REQUIRED_COLOUR_PER_PAGE = 10;
    int levelOfCMYK = 100;
    boolean isCMYK = true;

    @Override
    public int getRemainingPagesCount() {
        if (isCMYK == false) {
            return 0;
        } else {
            return (levelOfCMYK / REQUIRED_COLOUR_PER_PAGE);
        }
    }

    @Override
    public void print(int pages) {
        if (paperCount >= pages && (levelOfCMYK/REQUIRED_COLOUR_PER_PAGE) >= pages) {
            paperCount -= pages;
            levelOfCMYK -= (REQUIRED_COLOUR_PER_PAGE * pages);
        }
    }
}
