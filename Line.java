
public class Line {
    private Point start; // начало линии
    private Point end;   // конец линии

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
