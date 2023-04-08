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
public class MatrixPrinter extends Printer {
    private static final int REQUIRED_COLOUR_PER_PAGE = 10;
    private int numberOfPins = 9;
    private boolean isSpeed = false;
    private int levelOfCMYK = 60;

    @Override
    public String print(int pages) {
        if (paperCount >= pages && (levelOfCMYK / REQUIRED_COLOUR_PER_PAGE) >= pages) {
            paperCount -= pages;
            levelOfCMYK -= REQUIRED_COLOUR_PER_PAGE * pages;
            return "printed";
        }else{
            return "failed";
        }
    }

    @Override
    public int getRemainingPagesCount() {
        if (paperCount > (levelOfCMYK / REQUIRED_COLOUR_PER_PAGE)) {
            return levelOfCMYK / REQUIRED_COLOUR_PER_PAGE;
        } else {
            return paperCount;
        }
    }
}
