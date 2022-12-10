package dyve.aoc2022.day.day10;

public sealed interface Command permits Addx, Noop {

    State execute(Register register);

}
