package dyve.aoc2022.day.day9;

public class PlanckRope {

    private final Knot head;

    private final Knot tail;

    public PlanckRope(Knot head, Knot tail){
        this.head = head;
        this.tail = tail;
    }


    public Knot tail(){
        return tail;
    }

    public void moveHead(Direction direction){
        head.move(direction);
        adjustTail();
    }

    private void adjustTail() {
        tail.follow(head);
    }
}
