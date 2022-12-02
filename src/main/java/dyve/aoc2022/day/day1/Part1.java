package dyve.aoc2022.day.day1;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(1);
    }

    @Override
    protected Object execute(InputReader reader) {
        List<Elf> elves = new ArrayList<>();
        Elf elf = new Elf();
        for(String line : reader.stream().toList()){
            if(line.isEmpty()){
                elves.add(elf);
                elf = new Elf();
                continue;
            }
            elf.calories.add(Integer.decode(line));
        }

        return elves.stream().map(Elf::sum).max(Integer::compareTo).orElseThrow();
    }
}
