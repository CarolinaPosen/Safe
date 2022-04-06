package by.mikhalevich.stream;


import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {


        Reader reader = new Reader("src/file.txt");
        Integer safeSize = reader.getSafeSize();
        Thing[] thingsArray =  reader.getThingsList();



//массив промежуточных состояний рюкзака
//        Safe[][] safeCoordinates = new Safe[thingsArray.length + 1][safeSize + 1];
//
//        Safe[][] safeVariantsTable = SafePackerHandler.pack(safeSize, thingsArray, safeCoordinates);


//        SafePackerHandler.printVariants(thingsArray.length, safeSize, safeVariantsTable);
//        SafePackerHandler.findThingsForBackpack(safeVariantsTable);

        List<SafeHandler> safeHandlers = SafePackerStream.pack(thingsArray, safeSize);
        SafePackerStream.print(safeHandlers);


    }
}
