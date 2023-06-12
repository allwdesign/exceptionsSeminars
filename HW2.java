import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExHW2 {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        /* task1 */
        getUserFloatNumber();

        /* task2 */
        // Если необходимо, исправьте данный код

        try {
            int d = 0;
            int intArray[] = new int[] {57, 4, 33, 1, 45, 46, 2, 3, 7, 99};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

        /* task3 */
        // Дан следующий код, исправьте его там, где требуется

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            // At these point we have only two elements in the array
            // with indexes 0 and 1
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArithmeticException ex) {
            System.out.println("Catching exception: " + ex);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

        /* task4 */
        while (true) {
            try {
                getUserInputWithoutWhitespace();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /* task1 */
    public static float getUserFloatNumber() {
        /*
         * Реализуйте метод, который запрашивает у пользователя ввод дробного
         * числа (типа float), и возвращает введенное значение. Ввод текста вместо
         * числа не должно приводить к падению приложения, вместо этого, необходимо
         * повторно запросить у пользователя ввод данных.
         */
        String textForUser = "Enter the float number in format(2,14): ";
        String warningForUserIfWrongVal = "You are enter wrang value! ";

        float number = 0.0f;
        boolean flag = true;

        while (flag) {
            try {
                System.out.print(textForUser);
                number = userInput.nextFloat();
                // If an exception occurs, this line will never be executed.
                flag = false;
            } catch (InputMismatchException ex) { 
                System.out.print(warningForUserIfWrongVal);
                userInput.next();
            }

        }
        // System.out.println("Entered float number: " + number);
        return number;
    }

    /* task3 */
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    /* task4 */
    public static void getUserInputWithoutWhitespace() {
        /*
         * Разработайте программу, которая выбросит Exception, когда пользователь
         * вводит пустую строку. Пользователю должно показаться сообщение, что
         * пустые строки вводить нельзя.
         */
        String textForUser = "Enter something: ";
        String warningForUserIfWrongVal = "Empty lines are not allowed! ";

        System.out.print(textForUser);

        String inputString = userInput.nextLine();
        if (inputString.trim().isEmpty()) {
            throw new IllegalArgumentException(warningForUserIfWrongVal);
        } else {
            System.out.println("Entered string: " + inputString);
        }

    }

}
