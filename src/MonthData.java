import java.util.Arrays;

public class MonthData {
    public int[] days = new int[30];

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(String.format("%d день: %d", i + 1, days[i]));
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = Arrays.stream(days).sum(); // чуть-чуть считерил)))

        /*
         * int sumSteps = 0;
         *
         * for (int i = 0; i < days.length; i++) {
         *     sumSteps += days[i];
         * }
         *
         */

        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }

        return maxSteps;
    }

    public int bestSeries(int goal) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goal) {
                currentSeries++;
            }

            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }

        return finalSeries;
    }

    public double averageSteps() {
        return Arrays.stream(days).average().getAsDouble();
    }
}
