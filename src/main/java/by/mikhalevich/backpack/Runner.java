package by.mikhalevich.backpack;

public class Runner {
    public static void main(String[] args) {
        int safeWeights = 4; //объем сейфа
        int thingCount = 3; //число строк = число вещей
//массив вещей
        Thing[] things = {
                new Thing("телефон", 1, 1500),
                new Thing("компьютер", 4, 3000),
                new Thing("квадрокоптер", 3, 2000)};
//массив промежуточных состояний рюкзака
        Safe[][] safe = new Safe[thingCount + 1][safeWeights + 1];

        Safe[][] variantsTable = SafePacker.pack(safeWeights, things, safe);

        SafePacker.printVariants(things.length, safeWeights, variantsTable);

        SafePacker.findThingsForBackpack(variantsTable);

    }
}
