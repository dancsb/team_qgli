package View;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Mapet generáló osztály - Balázs Magic
 */
public abstract class MapGen {
    private final static int MAX_DEPTH = 100;

    private final static int LINE_MIN_BRANCH_NUMBER = 3;
    private final static int LINE_MAX_BRANCH_NUMBER = 5;

    private final static int LINE_MIN_LENGTH = 70;
    private final static int LINE_MAX_LENGTH = 200;

    private final static int LINE_MIN_ANGLE = 20;
    private final static int LINE_MAX_ANGLE = 150;

    private final static float MINIMUM_LINE_POINT_DIST = 1;

    private static Dimension size;
    private static ArrayList<Polygon> polygons;
    private static ArrayList<Line> lines;

    private static boolean tooClose(Line l, ArrayList<Line> lines) {
        for (Line line:lines)
            if (MapView.pEsVonalTav(l.getP2().x, l.getP2().y, line.getP1().x, line.getP1().y, line.getP2().x, line.getP2().y) < MINIMUM_LINE_POINT_DIST)
            {
                return true;
            }
        return false;
    }

    private static boolean doesntIntersects(Line l, ArrayList<Line> lines) {
        for (Line line:lines)
            if (Line2D.linesIntersect(l.getP1().x, l.getP1().y, l.getP2().x, l.getP2().y, line.getP1().x, line.getP1().y, line.getP2().x, line.getP2().y) &&
                    !(l.getP1().equals(line.getP1()) || l.getP1().equals(line.getP2()) || l.getP2().equals(line.getP1()) || l.getP2().equals(line.getP2())))
            {
                return false;
            }
        return true;
    }

    private static boolean genLines(Point start, int sPhi, int depth) {
        boolean success = false;

        if(depth == 0) {
            for (int i = 0; i < 5; i++) {
                if(genLinesRecuse(new Point(start), sPhi, depth, i * 72))
                    success = true;
            }
        }
        else if(depth < MAX_DEPTH){
            int n = ThreadLocalRandom.current().nextInt(LINE_MIN_BRANCH_NUMBER, LINE_MAX_BRANCH_NUMBER + 1);
            for (int i = 0; i < n; i++) {
                int phi = ThreadLocalRandom.current().nextInt(LINE_MIN_ANGLE, LINE_MAX_ANGLE + 1) * (ThreadLocalRandom.current().nextInt(0, 1 + 1) == 0 ? 1 : -1);
                if(genLinesRecuse(new Point(start), sPhi, depth, phi))
                    success = true;
            }
        }
        return success;
    }

    private static boolean genLinesRecuse(Point start, int sPhi, int depth, int phi) {
        int d = ThreadLocalRandom.current().nextInt(LINE_MIN_LENGTH, LINE_MAX_LENGTH + 1);
        double a = Math.toRadians(sPhi + phi);
        int x = start.x + (int) (d * Math.cos(a));
        int y = start.y + (int) (d * Math.sin(a));
        boolean outOfBounds = false;

        if(x < 0) {
            x = 0;
            outOfBounds = true;
        }
        if(x > size.width) {
            x = size.width;
            outOfBounds = true;
        }
        if(y < 0) {
            y = 0;
            outOfBounds = true;
        }
        if(y > size.height) {
            y = size.height;
            outOfBounds = true;
        }

        Point p = new Point(x, y);
        Line l = new Line(start, p);

        if(doesntIntersects(l, lines)){
            if (tooClose(l, lines)) {
                /*d -= MINIMUM_LINE_POINT_DIST;
                x = start.x + (int) (d * Math.cos(a));
                y = start.y + (int) (d * Math.sin(a));
                p = new Point(x, y);
                l = new Line(start, p);*/
                //return genLinesRecuse(start, sPhi, depth, phi);
            }
            lines.add(l);
            if(!outOfBounds)
                if(genLines(p, sPhi + phi, depth + 1) && depth != 0)
                    lines.get(lines.indexOf(l)).terminate();
            return true;
        }
        return false;
    }

    private static void connectLooseEnds() {
        ArrayList<Line> temp = new ArrayList<>();
        for (Line line:lines) {
            if(!line.isTerminated()) {
                int minD = 10000;
                Point minP = null;
                for (Line j:lines) {
                    if (line.getP2().distance(j.getP1()) < minD && !line.getP2().equals(j.getP1()) && doesntIntersects(new Line(line.getP2(), j.getP1()), lines) && doesntIntersects(new Line(line.getP2(), j.getP1()), temp) && !line.getP1().equals(j.getP1())) {
                        minD = (int) line.getP2().distance(j.getP1());
                        minP = j.getP1();
                    }
                    if (line.getP2().distance(j.getP2()) < minD && !line.getP2().equals(j.getP2()) && doesntIntersects(new Line(line.getP2(), j.getP2()), lines) && doesntIntersects(new Line(line.getP2(), j.getP2()), temp) && !line.getP1().equals(j.getP2())) {
                        minD = (int) line.getP2().distance(j.getP2());
                        minP = j.getP2();
                    }
                }
                if(minP != null) {
                    Line nl = new Line(new Point(line.getP2()), new Point(minP));
                    if(!temp.contains(nl))
                        temp.add(nl);
                }
            }
        }
        lines.addAll(temp);
    }

    private static void borderTop() {
        ArrayList<Line> temp = new ArrayList<>();
        for (Line line : lines)
            if(line.getP2().y == 0) {
                temp.add(line);
                line.terminate();
            }
        if (temp.size() == 0)
            lines.add(new Line(new Point(0, 0), new Point(size.width, 0), true));
        else {
            temp.sort(Comparator.comparingInt(a -> a.getP2().x));
            if (temp.get(0).getP2().x != 0)
                lines.add(new Line(new Point(0, 0), new Point(temp.get(0).getP2()), true));
            for (int i = 0; i < temp.size() - 1; i++)
                lines.add(new Line(new Point(temp.get(i).getP2().x, 0), new Point(temp.get(i + 1).getP2().x, 0), true));
            if (temp.get(temp.size() - 1).getP2().x != size.width)
                lines.add(new Line(new Point(temp.get(temp.size() - 1).getP2()), new Point(size.width, 0), true));
        }
    }

    private static void borderRight() {
        ArrayList<Line> temp = new ArrayList<>();
        for (Line line : lines)
            if(line.getP2().x == size.width) {
                temp.add(line);
                line.terminate();
            }
        if (temp.size() == 0)
            lines.add(new Line(new Point(size.width, 0), new Point(size.width, size.height), true));
        else {
            temp.sort(Comparator.comparingInt(a -> a.getP2().y));
            if (temp.get(0).getP2().y != 0)
                lines.add(new Line(new Point(size.width, 0), new Point(temp.get(0).getP2()), true));
            for (int i = 0; i < temp.size() - 1; i++)
                lines.add(new Line(new Point(size.width, temp.get(i).getP2().y), new Point(size.width, temp.get(i + 1).getP2().y), true));
            if (temp.get(temp.size() - 1).getP2().y != size.height)
                lines.add(new Line(new Point(temp.get(temp.size() - 1).getP2()), new Point(size.width, size.height), true));
        }
    }

    private static void borderBottom() {
        ArrayList<Line> temp = new ArrayList<>();
        for (Line line : lines)
            if(line.getP2().y == size.height) {
                temp.add(line);
                line.terminate();
            }
        if (temp.size() == 0)
            lines.add(new Line(new Point(0, size.height), new Point(size.width, size.height), true));
        else {
            temp.sort(Comparator.comparingInt(a -> a.getP2().x));
            if (temp.get(0).getP2().x != 0)
                lines.add(new Line(new Point(0, size.height), new Point(temp.get(0).getP2()), true));
            for (int i = 0; i < temp.size() - 1; i++)
                lines.add(new Line(new Point(temp.get(i).getP2().x, size.height), new Point(temp.get(i + 1).getP2().x, size.height), true));
            if (temp.get(temp.size() - 1).getP2().x != size.width)
                lines.add(new Line(new Point(temp.get(temp.size() - 1).getP2()), new Point(size.width, size.height), true));
        }
    }

    private static void borderLeft() {
        ArrayList<Line> temp = new ArrayList<>();
        for (Line line : lines)
            if(line.getP2().x == 0) {
                temp.add(line);
                line.terminate();
            }
        if (temp.size() == 0)
            lines.add(new Line(new Point(0, 0), new Point(0, size.height), true));
        else {
            temp.sort(Comparator.comparingInt(a -> a.getP2().y));
            if (temp.get(0).getP2().y != 0)
                lines.add(new Line(new Point(0, 0), new Point(temp.get(0).getP2()), true));
            for (int i = 0; i < temp.size() - 1; i++)
                lines.add(new Line(new Point(0, temp.get(i).getP2().y), new Point(0, temp.get(i + 1).getP2().y), true));
            if (temp.get(temp.size() - 1).getP2().y != size.height)
                lines.add(new Line(new Point(temp.get(temp.size() - 1).getP2()), new Point(0, size.height), true));
        }
    }

    private static void removeDuplicateLines() {
        for (int i = 0; i < lines.size() - 1; i++)
            for (int j = i + 1; j < lines.size(); j++)
                if (lines.get(i).equals(lines.get(j))) {
                    lines.remove(j);
                    i--;
                    break;
                }
    }

    private static void removeZeroLengthLines() {
        for (int i = 0; i < lines.size(); i++)
            if (lines.get(i).getP1().equals(lines.get(i).getP2())) {
                lines.remove(i);
                i--;
            }
    }

    private static void tagBorderLines() {
        for (Line line : lines)
            if((line.getP1().y == 0 && line.getP2().y == 0) || (line.getP1().x == size.width && line.getP2().x == size.width) || (line.getP1().y == size.height && line.getP2().y == size.height) || (line.getP1().x == 0 && line.getP2().x == 0))
                line.tag();
    }

    private static double calcLineAngle(Line line) {
        double angle = Math.toDegrees(Math.atan2((line.getP2().y - line.getP1().y), (line.getP2().x - line.getP1().x)));
        if((line.getP2().y - line.getP1().y) < 0)
            angle += 360;
        return angle;
    }

    private static void findPolygons(Line start) {
        Polygon poly = new Polygon();
        poly.addPoint(start.getP2().x, start.getP2().y);

        Point finnish = new Point(start.getP1());

        TreeMap<Double, Line> temp = new TreeMap<>();
        double selAngle;

        do {
            temp.clear();

            start.flip();
            double startAngle = calcLineAngle(start);
            start.flip();

            for (Line line : lines)
                if ((line.getP1().equals(start.getP2()) || line.getP2().equals(start.getP2())) && (!line.equals(start))) {
                    if (line.getP2().equals(start.getP2()))
                        line.flip();
                    temp.put(calcLineAngle(line), line);
                }

            selAngle = startAngle;

            for (Map.Entry<Double, Line> entry : temp.entrySet())
                if (entry.getKey() > selAngle) {
                    selAngle = entry.getKey();
                    break;
                }

            if(selAngle == startAngle)
                selAngle = temp.firstKey();

            start = temp.get(selAngle);

            poly.addPoint(temp.get(selAngle).getP2().x, temp.get(selAngle).getP2().y);

        } while (!temp.get(selAngle).getP2().equals(finnish));

        polygons.add(poly);
    }

    public static boolean polygonEquals(Polygon p1, Polygon p2) {
        if (p1.npoints != p2.npoints)
            return false;

        for (int i = 0; i < p1.npoints; i++) {
            boolean hit = false;
            for (int j = 0; j < p2.npoints; j++)
                if (p1.xpoints[i] == p2.xpoints[j] && p1.ypoints[i] == p2.ypoints[j]) {
                    hit = true;
                    break;
                }
            if (!hit)
                return false;
        }

        return true;
    }

    public static void removeDuplicatePolygons() {
        for (int i = 0; i < polygons.size() - 1; i++)
            for (int j = i + 1; j < polygons.size(); j++)
                if (polygonEquals(polygons.get(i), polygons.get(j))) {
                    polygons.remove(j);
                    i--;
                    break;
                }
    }

    public static ArrayList<Polygon> genMap(Dimension size) {
        MapGen.size = size;
        polygons = new ArrayList<>();
        lines = new ArrayList<>();

        boolean done = false;
        while(!done) {
            lines.clear();
            genLines(new Point(size.width / 2, size.height / 2), 0, 0);
            removeDuplicateLines();
            for (int i = 1; i < lines.size(); i++)
                if(lines.get(i).getP1().equals(new Point(size.width / 2, size.height / 2))) {
                    done = true;
                    break;
                }
        }

        borderTop();
        borderRight();
        borderBottom();
        borderLeft();

        removeDuplicateLines();

        connectLooseEnds();

        removeZeroLengthLines();

        removeDuplicateLines();

        tagBorderLines();

        for(Line line : lines)
            if(line.isNotTagged())
                findPolygons(line);

        for(Line line : lines)
            if(line.isNotTagged()) {
                line.flip();
                findPolygons(line);
            }

        removeDuplicatePolygons();

        return polygons;
    }
}
