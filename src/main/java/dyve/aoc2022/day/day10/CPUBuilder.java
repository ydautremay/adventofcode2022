package dyve.aoc2022.day.day10;

import dyve.aoc2022.input.InputReader;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPUBuilder {

    private static final Pattern ADDX = Pattern.compile("addx (-?\\d+)");


    public static CPU fromReader(InputReader reader){
        List<Command> commands = reader.stream().map(s -> {
            if(s.startsWith("noop")){
                return new Noop();
            }else{
                Matcher m = ADDX.matcher(s);
                m.matches();
                return Addx.withValue(Integer.parseInt(m.group(1)));
            }
        }).toList();
        return new CPU(commands);
    }
}
