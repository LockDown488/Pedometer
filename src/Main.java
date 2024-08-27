import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(sc);

        while (true) {
            printMenu();

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Введено неверное значение!");
            }
        }
    }

    static void printMenu() {
        System.out.println("Выберете опцию: ");
        System.out.println("1. Указать количество шагов");
        System.out.println("2. Указать цель по количеству шагов");
        System.out.println("3. Посмотреть статистику");
        System.out.println("4. Выход");
    }
}