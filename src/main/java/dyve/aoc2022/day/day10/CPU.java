package dyve.aoc2022.day.day10;

import java.util.ArrayList;
import java.util.List;

public class CPU {

    private final Register X = new Register();

    private final List<Command> commands = new ArrayList<>();

    private int cursor = 0;

    public CPU(List<Command> commands){
        this.commands.addAll(commands);
    }

    public void cycle(){
        Command command = commands.get(cursor);
        switch (command.execute(X)){
            case WORKING -> {}
            case DONE -> cursor++;
        }
    }

    public boolean hasNext(){
        return cursor < commands.size();
    }

    public int readRegister(){
        return X.value();
    }

}
