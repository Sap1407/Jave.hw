import java.util.Scanner;

public class Main {
    static final String DEVELOPER_NAME = "не указано";
    static final String DEVELOPER_GROUP = "не указана";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Эта программа вычисляет площадь круга по радиусу.");

        while (running) {
            printMenu();

            switch (readMenuChoice(scanner)) {
                case "1":
                    calculate(scanner);
                    break;
                case "2":
                    printProgramInfo();
                    break;
                case "3":
                    printDeveloperInfo();
                    break;
                default:
                    running = false;
                    break;
            }
        }

        System.out.println("Программа завершена.");
        scanner.close();
    }

    static void printMenu() {
        System.out.println();
        System.out.println("Главное меню");
        System.out.println("1. Выполнить расчёт");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
    }

    static String readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print("Выберите пункт меню: ");
            String line = readLine(scanner);

            if (line.equals("1") || line.equals("2") || line.equals("3")
                    || line.equals("4") || isExit(line)) {
                return line;
            }

            System.out.println("Нет такого пункта. Введите число от 1 до 4 или «выход».");
        }
    }

    static void calculate(Scanner scanner) {
        double radius = readRadius(scanner);

        if (radius < 0) {
            System.out.println("Расчёт отменён. Возврат в меню.");
            return;
        }

        System.out.println("Площадь круга: " + circleArea(radius));
    }

    static double readRadius(Scanner scanner) {
        while (true) {
            System.out.print("Введите радиус круга: ");
            String line = readLine(scanner);

            if (isExit(line)) {
                return -1;
            }

            try {
                double radius = Double.parseDouble(line.replace(',', '.'));
                if (radius > 0) {
                    return radius;
                }
                System.out.println("Ошибка: радиус должен быть больше нуля! Повторите ввод или введите «выход».");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести число. Повторите ввод или введите «выход».");
            }
        }
    }

    static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    static void printProgramInfo() {
        System.out.println("Эта программа вычисляет площадь круга по радиусу.");
        System.out.println("Формула: S = π · r · r.");
        System.out.println("Радиус должен быть больше нуля.");
    }

    static void printDeveloperInfo() {
        System.out.println("Информация о разработчике");
        System.out.println("ФИО: " + DEVELOPER_NAME);
        System.out.println("Группа: " + DEVELOPER_GROUP);
    }

    static boolean isExit(String line) {
        return line.equalsIgnoreCase("выход");
    }

    static String readLine(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return "выход";
        }
        return scanner.nextLine().trim();
    }
}
