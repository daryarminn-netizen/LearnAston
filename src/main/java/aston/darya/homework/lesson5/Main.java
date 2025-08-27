package aston.darya.homework.lesson5;

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[4][4];
        fillTwoDimensionalArray(array, false);

        try {
            int sum = sumTwoDimensionalArray(array);
            System.out.println("Сумма двумерного массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            generateArrayIndexException();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void generateArrayIndexException() {
        int[] array = new int[1];
        int x = array[2];
    }

    private static void fillTwoDimensionalArray(String[][] array, boolean dataException) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "" + (i + j);

                if (dataException && i == 3 && j == 2) {
                    array[i][j] = "asd";
                }
            }
        }
    }

    public static int sumTwoDimensionalArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива не 4х4");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (Exception ex) {
                    throw new MyArrayDataException(String.format("В ячейке (%s,%s) лежат неверные данные", i, j));
                }

            }
        }
        return sum;
    }
}
