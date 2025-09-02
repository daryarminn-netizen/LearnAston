package aston.darya.homework.Lesson_7_junit_5;

public class NumberComparator {

    /**
     * Метод сравнивает 2 числа.
     * <p>Если первое больше второго, возвращает положительное число,
     * <p>Если первое меньше второго, возвращает отрицательное число
     * <p>Если числа равны, возвращает 0
     */
    public static int compareNumbers(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
}
