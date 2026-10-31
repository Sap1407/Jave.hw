import java.util.Scanner;

public class task_5 {
    static double[] radii = new double[10];
    static double[] areas = new double[10];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = readMenuChoice(scanner);

            switch (choice) {
                case "1":
                    calculate(scanner);
                    break;
                case "2":
                    printResults();
                    break;
                case "3":
                    printProgramInfo();
                    break;
                case "4":
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
        System.out.println("2. Вывести результаты");
        System.out.println("3. Информация о программе");
        System.out.println("4. Выход");
    }

    static String readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print("Выберите пункт меню: ");
            String line = scanner.nextLine().trim();
            if (line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4")) {
                return line;
            }
            System.out.println("Нет такого пункта. Введите число от 1 до 4.");
        }
    }

    static void calculate(Scanner scanner) {
        double radius = readRadius(scanner);
        if (radius < 0) {
            System.out.println("Расчёт отменён. Возврат в меню.");
            return;
        }
        if (!checkCount()) {
            System.out.println("Массив заполнен. Возврат в меню.");
            return;
        }
        double area = computeArea(radius);
        saveResult(radius, area);
        System.out.println("Площадь круга: " + area);
    }

    static double readRadius(Scanner scanner) {
        while (true) {
            System.out.print("Введите радиус круга: ");
            String line = scanner.nextLine().trim();
            try {
                double radius = Double.parseDouble(line.replace(',', '.'));
                if (radius > 0) {
                    return radius;
                }
                System.out.println("Ошибка: радиус должен быть больше нуля!");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести число.");
            }
        }
    }

    static double computeArea(double radius) {
        return Math.PI * radius * radius;
    }

    static boolean checkCount() {
        return count < radii.length;
    }

    static void saveResult(double radius, double area) {
        radii[count] = radius;
        areas[count] = area;
        count++;
    }

    static void printResults() {
        if (count == 0) {
            System.out.println("Нет сохранённых результатов.");
            return;
        }
        System.out.println("Сохранённые результаты:");
        for (int i = 0; i < count; i++) {
            System.out.println("Радиус: " + radii[i] + ", Площадь: " + areas[i]);
        }
    }

    static void printProgramInfo() {
        System.out.println("Эта программа вычисляет площадь круга по радиусу.");
        System.out.println("Формула: S = π · r · r.");
        System.out.println("Радиус должен быть больше нуля.");
    }
}