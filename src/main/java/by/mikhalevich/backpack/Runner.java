package by.mikhalevich.backpack;

import by.mikhalevich.stream.SafeHandler;
import by.mikhalevich.stream.SafePackerStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {

//        int safeSize = 4; //объем сейфа
//        int thingCount = 3; //число строк = число вещей

//массив вещей
//        Thing[] things = {
//                new Thing("телефон", 1, 1500),
//                new Thing("компьютер", 4, 3000),
//                new Thing("квадрокоптер", 3, 2000)};


        Reader reader = new Reader("src/file.txt");
        Integer safeSize = reader.getSafeSize();
        Thing [] thingsArray =  reader.getThingsList();



//массив промежуточных состояний рюкзака
        Safe[][] safeCoordinates = new Safe[thingsArray.length + 1][safeSize + 1];

        Safe[][] safeVariantsTable = SafePacker.pack(safeSize, thingsArray, safeCoordinates);


        SafePacker.printVariants(thingsArray.length, safeSize, safeVariantsTable);
        SafePacker.findThingsForBackpack(safeVariantsTable);

//        List<SafeHandler> safeHandlers = SafePackerStream.pack(things);
//        SafePackerStream.print(safeHandlers);


    }
}
