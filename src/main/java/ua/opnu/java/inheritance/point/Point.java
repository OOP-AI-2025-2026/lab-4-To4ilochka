package ua.opnu.java.inheritance.point;

public class Point {
    public int x;
    public int y;

    public Point() {
        this(0, 0);
    }

    public Point(Point p) {
        this.setLocation(p.x, p.y);
    }

    public Point(int x, int y) {
        this.setLocation(x, y);
    }

    public double distanceFromOrigin() {
        return this.distance(new Point());
    }

    public double distance(Point p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}