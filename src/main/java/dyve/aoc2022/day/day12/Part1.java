package dyve.aoc2022.day.day12;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.day.dijkstra.Dijkstra;
import dyve.aoc2022.day.dijkstra.Graph;
import dyve.aoc2022.day.dijkstra.Height;
import dyve.aoc2022.day.dijkstra.Node;
import dyve.aoc2022.input.InputReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 extends Part {

    Map<Position, Node> nodes = new HashMap<>();

    public static void main(String[] args) throws Exception {
        new Part1().subMain(12);
    }

    @Override
    protected Object execute(InputReader reader) {
        List<String> entries = reader.stream().toList();
        Map<Position, Height> map = new HashMap<>();
        Map<Position, Node> nodes = new HashMap<>();
        Position start = null;
        Position end = null;
        Graph graph = new Graph();
        for(int y = 0; y < entries.size(); y++) {
            for (int x = 0; x < entries.get(0).length(); x++) {
                String alt = entries.get(y).substring(x, x+1);
                if(alt.equals("S")){
                    start = new Position(x, y);
                    alt = "a";
                }
                if(alt.equals("E")){
                    end = new Position(x, y);
                    alt = "z";
                }
                Position position = new Position(x, y);
                Node node = new Node(position.toString());
                graph.addNode(node);
                map.put(position, Height.valueOf(alt));
                nodes.put(position, node);
            }
        }
        for(Map.Entry<Position, Node> entry : nodes.entrySet()){
            Position left = entry.getKey().left();
            examinePath(map, nodes, entry, left);

            Position up = entry.getKey().up();
            examinePath(map, nodes, entry, up);

            Position right = entry.getKey().right();
            examinePath(map, nodes, entry, right);

            Position down = entry.getKey().down();
            examinePath(map, nodes, entry, down);
        }

        Dijkstra.calculateShortestPathFromSource(graph, nodes.get(start));
        return nodes.get(end).getDistance();
    }

    private void examinePath(Map<Position, Height> map, Map<Position, Node> nodes, Map.Entry<Position, Node> entry, Position targetposition) {
        Node targetNode = nodes.get(targetposition);
        if(targetNode != null) {
            if (map.get(targetposition).height <= map.get(entry.getKey()).height || map.get(targetposition).height - map.get(entry.getKey()).height <= 1) {
                entry.getValue().addDestination(targetNode, 1);
            }
        }
    }

}
