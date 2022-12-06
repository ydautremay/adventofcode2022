package dyve.aoc2022.day.day6;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.day.day1.Elf;
import dyve.aoc2022.input.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(6);
    }

    @Override
    protected Object execute(InputReader reader) {
        String input = reader.stream().findFirst().orElseThrow();
        loop1 : for(int i = 0; i < input.length() - 4; i++){
            String sub = input.substring(i, i + 4);
            for(char c : sub.toCharArray()) {
                if(sub.chars().filter(curr -> curr == (int) c).count() > 1){
                    continue loop1;
                }
            }
            return i + 4;
        }
        return "";
    }
}
