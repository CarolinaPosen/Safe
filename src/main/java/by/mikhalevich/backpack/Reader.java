package by.mikhalevich.backpack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private static final String SAFE = "safe";
    private static final String THING = "thing";

    private Integer safeSize = 0;
    private List<Thing> thingsList = new ArrayList<>();

    public Reader(String path) {
        BufferedReader file = null;
        try {
            file = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String fileLine;
            while ((fileLine = file.readLine()) != null) {
                String[] arguments = fileLine.split(" ");
                switch (arguments[0]) {
                    case (SAFE):
                        safeSize = Integer.parseInt(arguments[1]);
                        break;
                    case (THING):
                        thingsList.add((new Thing(arguments[1], Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]))));
                        break;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public Integer getSafeSize() {
        return safeSize;
    }


    public Thing[] getThingsList() {
        Thing[] thingsArray = new Thing[thingsList.size()];
        for (int i = 0; i < thingsList.size(); i++) {
            thingsArray[i] = thingsList.get(i);
        }
        return thingsArray;
    }

}
