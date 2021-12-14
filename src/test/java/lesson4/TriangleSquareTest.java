package lesson4;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static lesson4.TriangleSquare.triangleSquare;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleSquareTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleSquareTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("tests started");
    }

    @Test
    @DisplayName("Проверка метода triangleSquare, если стороны треугольника имеют отрицательное или нулевое значение")
    void testGivenNullOrMinusSideWhenTriangleSquareThenException() {
        assertAll(
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(1, 1, 0)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(1, 1, -1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(-1, -1, 1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(0, 0, -1))
        );
    }

    @Test
    @DisplayName("Проверка метода triangleSquare, где стороны и площадь - целые числа")
    void testGivenIntegersSidesWhenTriangleSquareThenCorrectResult() throws IncorectSideException {
        assertEquals(triangleSquare(6, 8, 10), 24);
    }


    @Test
    @DisplayName("Проверка метода triangleSquare, если стороны не образуют треугольник")
    void testGivenIncorrectSidesWhenTriangleSquareThenException() {
        assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(1, 2, 1));
    }

    @AfterAll
    static void afterAll() {
        logger.info("tests completed");
    }
}
