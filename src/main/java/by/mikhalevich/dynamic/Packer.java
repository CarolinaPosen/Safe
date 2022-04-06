package by.mikhalevich.dynamic;

import java.util.Collections;
import java.util.List;

public class Packer {

    public static Safe pack(Safe safe, List<Thing> things){

        things.sort(Collections.reverseOrder());

        int safeFillingVolume = 0;
        for (int i = 0; i < things.size(); i++) {
            if((safeFillingVolume + things.get(i).getVolume()) <= safe.getCapacity()){
                safe.getThings().add(things.get(i));
                safeFillingVolume += things.get(i).getVolume();
            }
        }
        return safe;
    }


}
