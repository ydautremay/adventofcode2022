package dyve.aoc2022.day.day10;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Part {


    public static void main(String[] args) throws Exception {
        new Part2().subMain(10);
    }

    @Override
    protected Object execute(InputReader reader) {
        CPU cpu = CPUBuilder.fromReader(reader);
        Screen screen = new Screen();

        int cycle = 0;
        while(cpu.hasNext()){
            cycle++;
            Sprite sprite = Sprite.fromMiddle(cpu.readRegister());
            screen.draw(sprite);
            cpu.cycle();
        }

        return screen.display();
    }
}
