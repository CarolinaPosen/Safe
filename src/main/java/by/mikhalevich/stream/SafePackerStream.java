package by.mikhalevich.stream;

import by.mikhalevich.backpack.Safe;
import by.mikhalevich.backpack.Thing;

import java.util.ArrayList;
import java.util.List;

public class SafePackerStream {
    private static List<SafeHandler> safes;

    public static List<SafeHandler> pack(Thing[] things){

        long count = things.length + 13;
         safes = new ArrayList<>();


        for (long state = 0; state < 64; state++) {
            Thing thing = new Thing("1", 1, 1);

            safes.add(new SafeHandler(new Thing[]{thing}, thing.getPrice()));
            safes.add(new SafeHandler(new Thing[]{}, thing.getPrice()));

        }
     return safes;
    }

    public static void print(List<SafeHandler> safes){

        for (SafeHandler safe : safes) {
            System.out.println(safe.getDescription()+ " ");
        }


    }

}
