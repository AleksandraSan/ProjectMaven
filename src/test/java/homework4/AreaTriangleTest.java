package homework4;

import lesson4.Function;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Array;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AreaTriangleTest {
    private static Logger logger = LoggerFactory.getLogger(AreaTriangleTest.class);

    @BeforeAll
    static void beforeAll(){
        logger.info("INFOLOG");
    }

    @BeforeEach
    void beforeEach(){
        logger.error("Testing error infolog");
    }

    @DisplayName("Проверка на корректность вычисления площади")
    @Test
    void calculateAreaTest() {
        Assertions.assertAll(
                () -> assertThat(new AreaTriangle().calculateAreaTriangle(new Integer[]{5, 4, 3})).isEqualTo(6),
                () -> assertThat(new AreaTriangle().calculateAreaTriangle(new Integer[]{4, 4, 2})).isLessThan(25),
                () -> assertThat(new AreaTriangle().calculateAreaTriangle(new Integer[]{4, 4, 4})).isBetween(6.90, 7.1)
        );
    }


    @Test
    @DisplayName("Cторона треугольника равна 0")
    void exeptionWhenSideIsNullTest() {
        Assertions.assertThrows(SideTriangleIsNull.class, () -> new AreaTriangle().calculateAreaTriangle(new Integer[]{5, 0, 8}));
    }

    @Test
    @DisplayName("Сторона треугольника равна отрицательному числу")
    void exeptionWhenSideIsNegigativeTest(){
        Assertions.assertThrows(SideTriangleIsNull.class, () -> new AreaTriangle().calculateAreaTriangle(new Integer[]{2, -5, 9}));
    }


    @Test
    @DisplayName("Сумма двух сторон должна быть больше чем третья длина стороны треугольника")
    void exeptionNoSuchTriangleTest() {
        Assertions.assertThrows(NoSuchTriangle.class, () -> new AreaTriangle().calculateAreaTriangle(new Integer[]{6, 6, 14}));
    }

}
