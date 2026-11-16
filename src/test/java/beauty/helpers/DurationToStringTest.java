package beauty.helpers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DurationToStringTest {

    @ParameterizedTest(name = "{0} мин -> {1}")
    @DisplayName("Только минуты (меньше часа)")
    @CsvSource({
            "0,    0 минут",
            "1,    1 минута",
            "2,    2 минуты",
            "4,    4 минуты",
            "5,    5 минут",
            "11,   11 минут",
            "21,   21 минута",
            "22,   22 минуты",
            "25,   25 минут",
            "45,   45 минут",
            "59,   59 минут"
    })
    void onlyMinutesTest(int input, String expected) {
        assertEquals(expected, DurationToString.getDurationAsString(input));
    }

    @ParameterizedTest(name = "{0} мин -> {1}")
    @DisplayName("Целое число часов (без минут)")
    @CsvSource({
            "60,   1 час",
            "120,  2 часа",
            "180,  3 часа",
            "240,  4 часа",
            "300,  5 часов",
            "660,  11 часов",
            "720,  12 часов",
            "1260, 21 час",
            "1320, 22 часа"
    })
    void wholeHoursTest(int input, String expected) {
        assertEquals(expected, DurationToString.getDurationAsString(input));
    }

    @ParameterizedTest(name = "{0} мин -> {1}")
    @DisplayName("Часы и минуты")
    @CsvSource({
            "61,   1 час 1 минута",
            "62,   1 час 2 минуты",
            "65,   1 час 5 минут",
            "90,   1 час 30 минут",
            "121,  2 часа 1 минута",
            "131,  2 часа 11 минут",
            "181,  3 часа 1 минута",
            "1811, 30 часов 11 минут"
    })
    void hoursAndMinutesTest(int input, String expected) {
        assertEquals(expected, DurationToString.getDurationAsString(input));
    }

    @Test
    @DisplayName("Отрицательное значение вызывает исключение")
    void negativeThrowsTest() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> DurationToString.getDurationAsString(-1)
        );
        assertTrue(ex.getMessage().contains("отрицательной"));
    }

    @ParameterizedTest(name = "негативные значения: {0}")
    @DisplayName("Любое отрицательное значение вызывает исключение")
    @ValueSource(ints = {-1, -60, -1000, Integer.MIN_VALUE})
    void anyNegativeThrowsTest(int input) {
        assertThrows(IllegalArgumentException.class,
                () -> DurationToString.getDurationAsString(input));
    }

    @Test
    @DisplayName("Граничные значения склонений 11–14")
    void teensDeclensionTest() {
        assertEquals("11 минут", DurationToString.getDurationAsString(11));
        assertEquals("12 минут", DurationToString.getDurationAsString(12));
        assertEquals("13 минут", DurationToString.getDurationAsString(13));
        assertEquals("14 минут", DurationToString.getDurationAsString(14));

        assertEquals("11 часов", DurationToString.getDurationAsString(660));
        assertEquals("12 часов", DurationToString.getDurationAsString(720));
        assertEquals("13 часов", DurationToString.getDurationAsString(780));
        assertEquals("14 часов", DurationToString.getDurationAsString(840));
    }
}