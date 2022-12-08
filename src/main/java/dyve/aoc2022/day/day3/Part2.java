package dyve.aoc2022.day.day3;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.List;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(3);
    }

    @Override
    protected Object execute(InputReader reader) {
        int priority = 0;
        List<String> rucksacks = reader.stream().toList();
        for(int i = 0; i < rucksacks.size() - 2; i = i + 3){
            Rucksack rucksack1 = new Rucksack(rucksacks.get(i));
            Rucksack rucksack2 = new Rucksack(rucksacks.get(i + 1));
            Rucksack rucksack3 = new Rucksack(rucksacks.get(i + 2));
            priority += rucksack1.content.chars().mapToObj(c -> String.valueOf((char) c))
                    .filter(rucksack2.content::contains)
                    .filter(rucksack3.content::contains)
                    .limit(1)
                    .mapToInt(s -> Letter.valueOf(s).value).sum();
        }

        return priority;
    }

}
