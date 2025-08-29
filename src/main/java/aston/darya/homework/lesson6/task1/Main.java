package aston.darya.homework.lesson6.task1;

import java.util.*;

/**
 * Задание 1
 * <p>
 * Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
 * Создайте коллекцию, содержащую объекты класса Student. Следует написать метод, который удаляет студентов со средним баллом < 3,
 * а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
 * Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
 * Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.
 */
public class Main {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        Map<String, Integer> grades = new HashMap<>();
        grades.put("Math", 4);
        grades.put("Computer", 3);
        grades.put("Physics", 2);
        grades.put("Engineer", 1);
        Student student1 = new Student("Анна", "TY-1", 1, grades);

        students.add(student1);

        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Physics", 5);
        grades1.put("Computer", 4);
        grades1.put("Engineer", 4);
        grades1.put("Math", 5);
        Student student2 = new Student("Miha", "F65-76", 3, grades1);

        students.add(student2);

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("English", 4);
        grades2.put("Math", 5);
        grades2.put("Computer", 4);
        grades2.put("Engineer", 4);
        Student student3 = new Student("Gera", "Re09-9", 2, grades2);

        students.add(student3);

        removeFailingStudents(students);
        moveStudent(students);
        printStudents(students, 4);
    }

    private static void printStudents(Set<Student> students, int course) {
        System.out.printf("Студенты курса-%s:\n", course);
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    private static void removeFailingStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = calculateAverageGrade(student);
            if (averageGrade < 3) {
                System.out.printf("Отчислен студент с баллом меньше 3. %s\n", student.getName());
                iterator.remove();
            }
        }
    }

    private static void moveStudent(Set<Student> students) {
        for (Student student : students) {
            double averageGrade = calculateAverageGrade(student);
            if (averageGrade >= 3) {
                student.setCourse(student.getCourse() + 1);
                System.out.printf("Cтудент %s зачислен на курс-%s\n", student.getName(), student.getCourse());
            }
        }
    }

    private static double calculateAverageGrade(Student student) {
        Map<String, Integer> grades = student.getGrades();

        int sum = 0;
        for (Integer grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

}
