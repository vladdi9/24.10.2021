package org.itstep;

import java.util.Arrays;
import java.util.Random;

public class Ragget {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5}, {2, 4}, {}};
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
        //Задаем случайное количество строк - 7..12
        //Для каждого из подмассивов задаем случайное количество элементов - 1..10
        Random random = new Random();
        int nrows = random.nextInt(6) + 7;
        arr = new int[nrows][];
        for (int i = 0; i < nrows; i++) {
            int ncols = random.nextInt(10) + 1;
            arr[i] = new int[ncols];
            for (int j = 0; j < ncols; j++)
                arr[i][j] = random.nextInt(100);
        }
        sortCols(arr);
        sortRows(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }

    //сортируем по строкам и колоннам
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swapRows(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //Отсортировать каждую строку
    public static void sortCols(int a[][]){
        for (int k=0; k<a.length; k++)
            for (int i = 0; i < a[k].length; i++)
                for (int j = 1; j < a[k].length - i; j++)
                    if (a[k][j-1] > a[k][j])
                        swap(a[k], j-1, j);
    }
    //Отсортировать в порядке возрастания количества элементов в строке
    public static void sortRows(int [][] a){
        for (int i=0; i<a.length; i++)
            for (int j=1; j<a.length-i; j++) {
                if (a[j - 1].length > a[j].length)
                    swapRows(a, j - 1, j);
                else if (a[j - 1].length == a[j].length&&a[j-1][0]>a[j][0])
                    swapRows(a,j-1,j);
            }
    }
}
