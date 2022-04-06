package by.mikhalevich.backpack;

import by.mikhalevich.stream.SafeHandler;
import by.mikhalevich.stream.SafePackerStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {

//        int safeWeights = 4; //объем сейфа
//        int thingCount = 3; //число строк = число вещей

//массив вещей
//        Thing[] things = {
//                new Thing("телефон", 1, 1500),
//                new Thing("компьютер", 4, 3000),
//                new Thing("квадрокоптер", 3, 2000)};


        Integer safeWeights = Reader.readSafeSize("src/file.txt");
        List<Thing> thingsList =  Reader.readThingsList("src/file.txt");

        Thing[] thingsArray = new Thing[thingsList.size()];

        for (int i = 0; i < thingsList.size(); i++) {
            thingsArray[i] = thingsList.get(i);
        }

//массив промежуточных состояний рюкзака
        Safe[][] safe = new Safe[thingsArray.length + 1][safeWeights + 1];

        Safe[][] variantsTable = SafePacker.pack(safeWeights, thingsArray, safe);
        SafePacker.printVariants(thingsArray.length, safeWeights, variantsTable);
        SafePacker.findThingsForBackpack(variantsTable);

//        List<SafeHandler> safeHandlers = SafePackerStream.pack(things);
//        SafePackerStream.print(safeHandlers);


    }
}
