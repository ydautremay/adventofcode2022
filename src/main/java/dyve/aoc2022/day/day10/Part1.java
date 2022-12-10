package dyve.aoc2022.day.day10;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 extends Part {


    public static void main(String[] args) throws Exception {
        new Part1().subMain(10);
    }

    @Override
    protected Object execute(InputReader reader) {
        CPU cpu = CPUBuilder.fromReader(reader);

        int cycle = 0;
        List<Integer> signals = new ArrayList<>();
        int signalCursor = 20;
        while(cpu.hasNext()){
            cycle++;
            if(cycle == signalCursor){
                signals.add(cycle * cpu.readRegister());
                System.out.println(cycle + " * " + cpu.readRegister() + " = " + cycle * cpu.readRegister());
                signalCursor = signalCursor + 40;
                if(signalCursor > 220){
                    break;
                }
            }
            cpu.cycle();
        }

        return signals.stream().mapToInt(i -> i).sum();
    }
}
