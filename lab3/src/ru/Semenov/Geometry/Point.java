package ru.Semenov.Geometry;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        Point pt = (Point) obj;

        if (this.x == pt.x && this.y == pt.y) {
            return true;
        } else return false;

    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
