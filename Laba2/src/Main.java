import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        byte[] arr = new byte[5];

        for (int i = 0; i < arr.length; i++)
        {
            try {
                System.out.println("Введіть число:");
                arr[i] = input.nextByte();
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Не вірний формат!");
                input.next();
            }
        }
        maxElement finder = new maxElement();
        try {
            byte x = finder.main(arr);
            System.out.println(x);
        }
        catch (NegativeOnlyArrayException exception)
        {
            System.out.println(exception.getMessage());
        }

    }
}