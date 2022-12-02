package dyve.aoc2022.day.day1;

import java.util.ArrayList;
import java.util.List;

public class Elf {

    List<Integer> calories = new ArrayList<>();

    int sum(){
        return calories.stream().mapToInt(Integer::intValue).sum();
    }
}
