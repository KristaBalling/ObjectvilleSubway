package com.theironyard;

import java.io.File;
import java.util.List;

public class SubwayTester {
    public static void main(String[] args) {
        if (args.length !=2) {
            System.err.println("Usage: SubwayTester [startStation] [endStation]");
            System.exit(-1);
        }
        try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville =
                    loader.loadFromFile(new File("ObjectvilleSubway.txt"));

            if (!objectville.hasStation(args[0])) {
                System.err.println(args[0] + " is not a station in Objectville.");
                System.exit(-1);
            } else if (!objectville.hasStation(args[1])) {
                System.err.println(args[1] + " is not a station in Objectville.");
                System.exit(-1);
            }

            List route = objectville.getDirections(args[0], args[1]);
            SubwayPrinter printer = new SubwayPrinter(System.out);
            printer.printDirections(route);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
