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
public class SublimationPrinter extends Printer {
    private static final int REQUIRED_COLOUR_PER_PAGE = 10;
    private int levelOfCMYK = 60;
    private int temperature = 0;

    @Override
    public String print(final int pages) {
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
