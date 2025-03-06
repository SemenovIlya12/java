import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> p) {
        this.points = p;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Line [");
        for (Point p : this.points) {
            sb.append(p.toString() + ", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
