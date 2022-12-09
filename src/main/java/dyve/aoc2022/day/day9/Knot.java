package dyve.aoc2022.day.day9;

public class Knot {

    private Position position;

    public Knot(Position position){
        this.position = position;
    }

    public static Knot of(int x, int y){
        return new Knot(Position.of(x, y));
    }

    public int x(){
        return position.x();
    }

    public int y(){
        return position.y();
    }

    public Position position(){
        return this.position;
    }

    public void move(Direction direction){
        position = switch (direction){
            case U -> Position.of(position.x(), position.y() + 1);
            case D -> Position.of(position.x(), position.y() - 1);
            case L -> Position.of(position.x() - 1, position.y());
            case R -> Position.of(position.x() + 1, position.y());
        };
    }

    public void follow(Knot other){
        if(isTouching(other)){
            return;
        }
        if(this.x() > other.x()){
            this.move(Direction.L);
        }else if(this.x() < other.x()){
            this.move(Direction.R);
        }
        if(this.y() > other.y()){
            this.move(Direction.D);
        }else if(this.y() < other.y()){
            this.move(Direction.U);
        }
    }

    private boolean isTouching(Knot other){
        return Math.abs(this.x() - other.x()) < 2 && Math.abs(this.y() - other.y()) < 2;
    }
}
