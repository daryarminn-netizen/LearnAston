package aston.darya.homework.lesson6.task2;

/**
 * Написать простой класс Телефонный Справочник, который хранит
 * в себе список фамилий и телефонных номеров. В этот телефонный
 * справочник с помощью метода add() можно добавлять записи, а с помощью
 * метода get() искать номер телефона по фамилии. Следует учесть,
 * что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class Main {

    public static void main(String[] args) {
        PhoneBook phBook = new PhoneBook();
        phBook.add("Smirnov", 89176165421L);
        phBook.add("Fauller", 89176168461L);
        phBook.add("Marfil", 89986168462L);
        phBook.add("Karlich", 89126168463L);
        phBook.add("Karlich", 89126168664L);
        phBook.add("Arvind", 8932611065L);
        phBook.add("Bortich", 8900617661L);
        phBook.add("Muhtoyar", 8900617662L);
        phBook.add("Popov", 8900617662L);

        System.out.println("\nВсе контакты:");
        phBook.printAllContactsSorted();

        System.out.printf("\nПоиск контакта по Karlich: %s", phBook.get("Karlich"));
    }
}
