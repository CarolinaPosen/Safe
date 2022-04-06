package by.mikhalevich.dynamic;

import by.mikhalevich.backpack.Thing;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        by.mikhalevich.dynamic.Thing thing1 = new by.mikhalevich.dynamic.Thing("thing1", 1, 1);
        by.mikhalevich.dynamic.Thing thing2 = new by.mikhalevich.dynamic.Thing("thing2", 2, 2);
        by.mikhalevich.dynamic.Thing thing3 = new by.mikhalevich.dynamic.Thing("thing3", 3, 3);
        by.mikhalevich.dynamic.Thing thing4 = new by.mikhalevich.dynamic.Thing("thing4", 5, 4);
        by.mikhalevich.dynamic.Thing thing5 = new by.mikhalevich.dynamic.Thing("thing5", 5, 5);

        List<by.mikhalevich.dynamic.Thing> things = new ArrayList<>();

        things.add(thing2);
        things.add(thing3);
        things.add(thing1);
        things.add(thing4);
        things.add(thing5);

        Thing[] items = {new Thing("гитара", 1, 1500),
                new Thing("бензопила", 4, 3000),
                new Thing("ноутбук", 3, 2000)};

        Safe safe = new Safe(10);

        Safe fillSafe = Packer.pack(safe, things);

        System.out.println(fillSafe);

    }
}
