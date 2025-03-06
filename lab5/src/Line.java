public class Line {
    private Point start;
    private Point end;

    public Line(Point s, Point e) {
        this.start = s;
        this.end = s;
    }

    @Override
    public String toString() {
        return "Line from " + this.start.toString() + " to " + this.end.toString();
    }
}
