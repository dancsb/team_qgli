package View;

import java.awt.*;
import java.util.Objects;

/**
 * Vonalakat reprezentáló osztály
 */
public class Line {
    /**
     * A vonal kezdeti pontja
     */
    private final Point p1;
    /**
     * A vonal végpontja
     */
    private final Point p2;
    /**
     * A bool ami reprezentálja,hogy a vonal 2 pontjához kapcsolódik-e másik vonal
     */
    private boolean terminated;
    /**
     * A vonal az ablak keretében van-e
     */
    private boolean tagged;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.terminated = false;
        this.tagged = false;
    }

    public Line(Point p1, Point p2, boolean terminated) {
        this.p1 = p1;
        this.p2 = p2;
        this.terminated = terminated;
        this.tagged = false;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public void flip() {
        int tempX = p1.x;
        int tempY = p1.y;
        p1.x = p2.x;
        p1.y = p2.y;
        p2.x = tempX;
        p2.y = tempY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (Objects.equals(p1, line.p1) && Objects.equals(p2, line.p2)) || (Objects.equals(p1, line.p2) && Objects.equals(p2, line.p1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void terminate() {
        terminated = true;
    }

    public boolean isNotTagged() {
        return !tagged;
    }

    public void tag() {
        this.tagged = true;
    }
}
