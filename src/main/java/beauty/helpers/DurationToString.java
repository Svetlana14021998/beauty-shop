package beauty.helpers;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DurationToString {

    public static String getDurationAsString(Integer totalMinutes) {
        if (totalMinutes < 0) {
            throw new IllegalArgumentException("Длительность не может быть отрицательной: " + totalMinutes);
        }

        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        if (hours == 0) {
            return minutes + " " + minuteWord(minutes);
        }

        if (minutes == 0) {
            return hours + " " + hourWord(hours);
        }

        return hours + " " + hourWord(hours) + " " + minutes + " " + minuteWord(minutes);
    }

    private static String hourWord(int hours) {
        int mod100 = hours % 100;
        int mod10 = hours % 10;
        if (mod100 >= 11 && mod100 <= 14) return "часов";
        return switch (mod10) {
            case 1 -> "час";
            case 2, 3, 4 -> "часа";
            default -> "часов";
        };
    }

    private static String minuteWord(int minutes) {
        int mod100 = minutes % 100;
        int mod10 = minutes % 10;
        if (mod100 >= 11 && mod100 <= 14) return "минут";
        return switch (mod10) {
            case 1 -> "минута";
            case 2, 3, 4 -> "минуты";
            default -> "минут";
        };
    }
}
