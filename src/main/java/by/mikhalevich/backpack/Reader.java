package by.mikhalevich.backpack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static final String SAFE = "safe";
    public static final String THING = "thing";

    private static Integer safeSize;
    private static ArrayList<Thing> thingsList;

    public static Integer readSafeSize(String path) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String fileLine;
        while ((fileLine = file.readLine()) != null) {
            String[] arguments = fileLine.split(" ");
            if (SAFE.equals(arguments[0])) {
                safeSize = Integer.parseInt(arguments[1]);
            }
//            file.close();
        }
        return safeSize;
    }

        public static List<Thing> readThingsList (String path) throws IOException {

            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            List<Thing> list = new ArrayList<>();

            String fileLine;
            while ((fileLine = file.readLine()) != null) {

                String[] arguments = fileLine.split(" ");

                if (THING.equals(arguments[0])) {
                    list.add(new Thing(arguments[1], Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3])));
                }

            }
//            file.close();
            return list;
        }


    }
