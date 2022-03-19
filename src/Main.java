import MyExceptions.MyArrayDataException;
import MyExceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {


        Object[][] ar_ok = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2.6, 3, 4}, {1, 2, 3, 4.1f}};
        Object[][] ar_ok_int = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        Object[][] ar_wrong_size = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {1, 2, 3}};
        Object[][] ar_wrong_data = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {1, 2, 3, "четыре"}};


        try {
            System.out.println("Результат сложения массива ar_ok: " + sumArray(ar_ok));
            System.out.println("Результат сложения массива ar_ok_int: " + sumArray(ar_ok_int));
            System.out.println("Результат сложения массива ar_wrong_data: " + sumArray(ar_wrong_data));
            System.out.println("Результат сложения массива ar_wrong_size: " + sumArray(ar_wrong_size));

        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Сработало исключение " + e);
        }

    }


    public static void checkArraySize(Object[][] ar) throws MyArraySizeException {
        if (ar.length != 4) {
            throw new MyArraySizeException();
        }
        for (Object[] objects : ar) {
            if (objects.length != 4) {
                throw new MyArraySizeException("Неверный размер массива");
            }
        }
    }


    public static int sumArray(Object[][] ar) throws MyArrayDataException, MyArraySizeException {
        checkArraySize(ar);
        double temp = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                try {
                    temp += Double.parseDouble(ar[i][j].toString());
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибочное значение в ячейке массива " + i + ":" + j);
                }
            }
        }
        return Math.toIntExact(Math.round(temp));
    }
}
