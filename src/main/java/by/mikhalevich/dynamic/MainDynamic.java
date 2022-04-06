package by.mikhalevich.dynamic;

import java.util.ArrayList;

public class MainDynamic {

    public static void main(String[] args) {


        int[] weights = {3, 4, 5, 8, 9}; // Веса предметов
        int[] prices = {1, 6, 4, 7, 6}; // Цена предметов

        int count = weights.length; // 5 Предметов
        int maxWeight = 13; // Размер рюкзака

        /**
         * Массив оптимальных стоимостей
         *  1 - индекс количество предметов; 2 индекс - размер рюкзака;
         *  Значение по координатам массива соответствует наполненному рюкзаку в определённый момент времени
         */
        int[][] a = new int[count + 1][];

        for (int i = 0; i < count + 1; i++) {
            a[i] = new int[maxWeight + 1];
        }

        for (int k = 0; k <= count; k++) { // Размер набора предметов в переменной k
            for (int s = 0; s <= maxWeight; s++) { // Размер рюкзака
                if (k == 0 || s == 0) { // Если набор предметов или размер рюкзака равны 0
                    a[k][s] = 0; // Первая строка таблицы забита нулями
                } else {
                    if (s >= weights[k - 1]) { // Иначе если размер рюкзака больше или равен размеру текущего предмета
                        a[k][s] = Math.max(a[k - 1][s], a[k - 1][s - weights[k - 1]] + prices[k - 1]); // А если предмет помещается выбираем максимальный вариант
                    } else {
                        a[k][s] = a[k - 1][s]; // Не кладем такой предмет в рюкзак
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(a, weights, count, maxWeight, result);

        System.out.println("Оптимальное содержимое рюкзака:");
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    /**
     * Второй раз необходимо пройти по таблице, что бы понять какие предметы мы все таки выбрали
     * int[][] A - матрица оптимальной стоимости
     * int[] weight - веса предметов
     * int k - размер текущего набора предметов
     * int s - размер текущего рюкзака
     * ArrayList<Integer> result - лис для накопления предметов, которые входят в оптимальный набор
     */

    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k - 1][s] == A[k][s]) {
            traceResult(A, weight, k - 1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }
}