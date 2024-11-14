package plotter;

import java.awt.Point;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polyline {
    private ArrayList<Point> points;
    private int width;
    private String color;
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Polyline> list = readFile("hello.txt");
        Plotter plotter = new Plotter();

        for (Polyline p : list) {
            p.plotWithPlotter(plotter);
        }
    }
    public Polyline(String givenColor) {
        this(givenColor, 1);
    }

    public Polyline(String givenColor, int givenWidth) {
        color = givenColor;
        width = givenWidth;
        points = new ArrayList<Point>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    private static Polyline parseOneLine(String line) {
    	String[] parts = line.trim().split("\\s+");
        String color;
        int width = 1;
        int startIndex;

       
        if (parts[0].matches("\\d+")) {
            width = Integer.parseInt(parts[0]);
            color = parts[1];
            startIndex = 2;
        } else {
            color = parts[0];
            startIndex = 1;
        }

        
        Polyline polyline = new Polyline(color, width);

       
        for (int i = startIndex; i < parts.length; i += 2) {
            if (i + 1 < parts.length) {
                int x = Integer.parseInt(parts[i]);
                int y = Integer.parseInt(parts[i + 1]);
                polyline.addPoint(new Point(x, y));
            }
        }

        
        

        return polyline;
    }


    public void plotWithPlotter(Plotter plotter) {
        plotter.setColor(color);
        plotter.setWidth(width);

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            plotter.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    
}
