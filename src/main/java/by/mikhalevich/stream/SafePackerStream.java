package by.mikhalevich.stream;

import java.util.ArrayList;
import java.util.List;

public class SafePackerStream {
    private static List<SafeHandler> safeHandlers;

    public static List<SafeHandler> pack(Thing[] things, Integer safeSize){

        safeHandlers = new ArrayList<>();
        int counter = 0;

        int countOfPosition = things.length*safeSize;

        for (int state = 0; state < countOfPosition; state++) {

            SafeHandler safeHandler = new SafeHandler();
            safeHandler.setIndex(state);

            if(safeHandler.getIndex()%safeSize==0){
                counter++;
            }

            if(things[counter-1].getWeight() > safeHandler.getIndex()){
                Thing[] myArray = new Thing[counter];
                System.arraycopy(things, 0, myArray, 0, counter);

                safeHandler.setSafe(new Safe(null));
            } else {

                Thing[] myArray = new Thing[counter];
                System.arraycopy(things, 0, myArray, 0, counter);

                safeHandler.setSafe(new Safe(myArray));

            }

            safeHandlers.add(safeHandler);

        }
     return safeHandlers;
    }

    public static void print(List<SafeHandler> safeHandlers){
        for (SafeHandler safeHandler : safeHandlers) {
//            System.out.println(safeHandler.getSafe().getDescription()+ " ");
            System.out.println(safeHandler.getIndex()+" "+safeHandler.getSafe());
        }
    }

}
