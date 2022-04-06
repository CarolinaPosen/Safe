package by.mikhalevich.backpack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SafePacker {

//    int k = 4; //грузоподъёмность рюкзака safeWeights
//    int n = 3; //число строк = число вещей numberOfThings = things.length

    public static Safe[][] pack(int safeWeights, Thing[] things, Safe[][] safes){

        // Перебераем все предметы
        for (int i = 0; i < things.length + 1; i++) {

            // Перебераем все варианты веса, которые поддерживает Сейф
            for (int j = 0; j < safeWeights + 1; j++) {


                if (i == 0 || j == 0) { //нулевую строку и столбец заполняем нулями
                    safes[i][j] = new Safe(new Thing[]{}, 0);
                } else
                    if (i == 1) {

                    /*первая строка заполняется просто: первый предмет кладём или не кладём в зависимости от веса.*/
                    safes[1][j] =

                            things[0].getWeight() <= j //Помещается ли предмет в текущий (j) вариант веса сейфа
                            ? new Safe(new Thing[]{things[0]}, things[0].getPrice())
                            : new Safe(new Thing[]{}, 0);

                } else {
                    if (things[i - 1].getWeight() > j) //если очередной предмет не влезает в сейф,
                        safes[i][j] = safes[i - 1][j];    //записываем предыдущий максимум
                    else {
                        /*рассчитаем цену очередного предмета + максимальную цену для (максимально возможный для рюкзака вес − вес предмета)*/
                        int newPrice = things[i - 1].getPrice() + safes[i - 1][j - things[i - 1].getWeight()].getPrice();
                        if (safes[i - 1][j].getPrice() > newPrice) //если предыдущий максимум больше
                            safes[i][j] = safes[i - 1][j]; //запишем его
                        else {
                            /*иначе фиксируем новый максимум: текущий предмет + стоимость свободного пространства*/
                            safes[i][j] = new Safe(Stream.concat(Arrays.stream(new Thing[]{things[i - 1]}),
                                    Arrays.stream(safes[i - 1][j - things[i - 1].getWeight()].getItems())).toArray(Thing[]::new), newPrice);
                        }
                    }
                }


            }
            
        }
        return safes;
    }

    public static Safe[][] printVariants(int numberOfThings, int safeWeights, Safe[][] bp){
        for (int i = 1; i < numberOfThings + 1; i++) {
            for (int j = 1; j < safeWeights + 1; j++) {
                System.out.print(bp[i][j].getDescription() + " ");
            }
            System.out.print("\n");
        }
        return bp;
    }

    public static void findThingsForBackpack(Safe[][] variantsTable){
        List<Safe> lastColumn = Arrays.stream(variantsTable).map(row -> row[row.length - 1]).collect(Collectors.toList());
        Safe variantsTableWithMax = lastColumn.stream().max(Comparator.comparing(Safe::getPrice)).orElse(new Safe(null, 0));
        System.out.println(variantsTableWithMax.getDescription());
    }

}