import java.util.Scanner;

public class StepTracker {
    private static final String INCORRECT_STEPS_COUNT = "Неверное количество шагов!";

    private Scanner scanner;
    private MonthData monthData;
    private Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12];
    private int goalByStepsPerDay = 10000;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public int getGoal() {
        return goalByStepsPerDay;
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (1 - 12): ");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Неверный номер месяца!");
            return;
        }

        System.out.println("Введите день (1 - 30): ");
        int day = scanner.nextInt();

        if (day < 1 || day > 30) {
            System.out.println("Неверный номер дня!");
            return;
        }

        System.out.println("Введите количество шагов: ");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println(INCORRECT_STEPS_COUNT);
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;

        System.out.println("Данные сохранены!");
    }

    public void changeStepGoal() {
        System.out.println("Введите количество шагов, которые Вы хотите проходить за день: ");
        int goal = scanner.nextInt();

        if (goal > 0) {
            goalByStepsPerDay = goal;
        } else {
            System.out.println(INCORRECT_STEPS_COUNT);
            return;
        }

        System.out.println("Новая цель по количеству шагов за день установлена!");
    }

    public void printStatistic() {
        System.out.println("Введите номер месяца (1 - 12): ");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Неверный номер месяца!");
            return;
        }

        monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
        System.out.println(String.format("За месяц Вы прошли %d шагов!", sumSteps));
        System.out.println(String.format("Максимальное количество шагов за месяц - %d шагов!", monthData.maxSteps()));
        System.out.println(String.format("Среднее количество шагов за месяц - %d шагов!", (int) monthData.averageSteps()));
        System.out.println(String.format("За месяц Вы прошли около %d километров", converter.convertToKm(sumSteps)));
        System.out.println(String.format("За месяц Вы сожгли около %d ккал", converter.convertStepsToKilocalories(sumSteps)));
        System.out.println(String.format("Лучшая серия выполнения цели по количеству шагов - %d дней подряд!", monthData.bestSeries(goalByStepsPerDay)));
        System.out.println();
    }
}
