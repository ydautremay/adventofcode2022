package dyve.aoc2022.day.day13;

import dyve.aoc2022.input.InputReader;

import java.util.ArrayList;
import java.util.List;

public class PacketReader {

    public static List<Pair> readPairs(InputReader reader){
        List<Pair> pairs = new ArrayList<>();
        Packet packet1 = null;
        Packet packet2 = null;
        boolean first = false;
        for(String line : reader.stream().toList()){
            if(line.isBlank()){
                Pair pair = new Pair(packet1, packet2);
                pairs.add(pair);
                continue;
            }
            first = !first;
            if(first){
                packet1 = readPacket(line);
            }else{
                packet2 = readPacket(line);
            }
        }

        return pairs;
    }

    public static List<Packet> readPackets(InputReader reader){
        return reader.stream().filter(s -> !s.isEmpty()).map(PacketReader::readPacket).toList();
    }

    private static Packet readPacket(String line){
        Packet packet = new Packet();
        ListContent currentList = packet.getListContent();
        String currentValue = "";
        for(int i = 1; i < line.length(); i++){
            char c = line.charAt(i);
            if(String.valueOf(c).matches("\\d")){
                currentValue += c;
            }
            if(c == '['){
                currentList = new ListContent(currentList);
            }
            if(c == ']'){
                if(!currentValue.isEmpty()){
                    currentList.getContents().add(new IntegerContent(Integer.parseInt(currentValue), currentList));
                    currentValue = "";
                }
                if(currentList.getParent() != null){
                    currentList.getParent().getContents().add(currentList);
                }
                currentList = currentList.getParent();
            }
            if(c == ','){
                if(!currentValue.isEmpty()) {
                    currentList.getContents().add(new IntegerContent(Integer.parseInt(currentValue), currentList));
                    currentValue = "";
                }
            }
        }
        return packet;
    }
}
