package dyve.aoc2022.day.day5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Platform {

    final List<Deque<String>> stacks = new ArrayList<>();

    void move(int from, int to){
        String crate = stacks.get(from - 1).removeLast();
        stacks.get(to - 1).addLast(crate);
    }

    void moveGroup(int nb, int from, int to){
        Deque<String> temp = new ArrayDeque<>();
        for (int i = 0; i < nb; i++){
            temp.addFirst(stacks.get(from - 1).removeLast());
        }
        for (int i = 0; i < nb; i++){
            stacks.get(to - 1).addLast(temp.removeFirst());
        }
    }

    static Platform fromInput(List<String> inputs){
        Platform platform = new Platform();
        String lastLine = inputs.get(inputs.size() - 1);
        int nbStacks = Integer.parseInt(lastLine.substring(lastLine.length() - 1));
        for (int i = 0; i < nbStacks; i++){
            platform.stacks.add(new ArrayDeque<>());
        }
        for (int i = 0; i < inputs.size() - 1; i++){
            for(int j = 0; j < nbStacks * 4;  j = j + 4){
                String crate = inputs.get(i).substring(j + 1, j + 2);
                if(!crate.equals(" ")){
                    platform.stacks.get(j/4).addFirst(crate);
                }
                if(j + 4 > inputs.get(i).length()){
                    break;
                }
            }
        }
        return platform;
    }
}
