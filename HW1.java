import java.util.Arrays;

public class HW1 {

    public static void main(String[] args) {

        /* task1 */
        // Реализуйте 3 метода, чтобы в каждом из них получить разные стандартные
        // для Java исключения;
        getNumberFormatException();
        getStringIndexOutOfBoundsException();
        getNullPointerException();

        /* task2 */
        // Посмотрите на код, и подумайте сколько разных типов исключений вы тут
        // сможете получить?
        // public static int sum2d(String[][] arr) {
        // int sum = 0;
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < 5; j++) {
        // int val = Integer.parseInt(arr[i][j]);
        // sum += val;
        // }
        // }
        // return sum;
        // }
        // 1. ArrayIndexOutOfBoundsException Выход за пределы границ массива
        // 2. NumberFormatException Если массив заполнен null-ами или строки
        // будут содержать символы кроме чисел

        /* task3 */
        // The lengths of the arrays are not equal
        // int[] arr1 = new int[] {35, 2, 99, 0, 41};
        // int[] arr2 = new int[] {6, 40, 88, 1};

        // The lengths of the arrays are equal
        int[] arr1 = new int[] { 35, 2, 99, 0, 41 };
        int[] arr2 = new int[] { 6, 40, 88, 1, 31 };

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        int[] elementDifference = numberDifference(arr1, arr2);
        if (elementDifference != null) {
            System.out.println("Result: " + Arrays.toString(elementDifference));
        }

        /* task4 */
        divideNumbers(arr1, arr2);
        // Divide by zero
        divideNumbers(arr2, arr1);

    }

    public static int getNumberFormatException() {
        /*
         * NumberFormatException
         * 
         * Вызов метода Integer.parseInt() с некорректной строкой
         */
        String data = "nelioiuiuyu";
        int value = Integer.parseInt(data);
        return value;
    }

    public static void getNullPointerException() {
        /*  */
        Integer num = null;
        System.out.println(num.toString());

    }

    public static void getStringIndexOutOfBoundsException() {
        /*
         * Нет символа в строке с индексом 52, (с 0 по 51 включительно)
         * 
         * Для исправления кода:
         * нужно прописать в условии цикла i < alfavit.length()
         */
        String alfavit = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Length: " + alfavit.length());
        int i = 0;
        while (i <= alfavit.length()) {

            char c = alfavit.charAt(i);
            int code = (int) c;
            System.out.println("буква:" + c + "\tкод:" + code);
            i++;
        }
    }

    public static int[] numberDifference(int[] arr1, int[] arr2) {
        /*
         * 3 Реализуйте метод, принимающий в качестве аргументов два
         * целочисленных массива, и возвращает новый массив, каждый элемент
         * которого равен разности элементов двух входящих массивов в той же
         * ячейке. Если длины массивов не равны, необходимо как-то оповестить
         * пользователя.
         */

        if (arr1.length != arr2.length) {
            throw new RuntimeException("Array lengths are not equal");
        }

        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static int[] divideNumbers(int[] arr1, int[] arr2) {
        /*
         * 4 (Не обязательное)* Реализуйте метод, принимающий в качестве
         * аргументов два целочисленных массива, и возвращает новый массив,
         * каждый элемент которого равен частному элементов двух входящих
         * массивов в той же ячейке.
         * Если длины массивов не равны, необходимо как-то оповестить
         * пользователя.
         * Важно: При выполнении метода единственное исключение, которое
         * пользователь может увидеть - RuntimeException, т.е. ваше.
         */

        if (arr1.length != arr2.length) {
            throw new RuntimeException("Array lengths are not equal");
        }

        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("You can't divide by zero");
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }

}
