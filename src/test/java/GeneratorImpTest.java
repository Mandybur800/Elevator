import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorImpTest {
    private static GeneratorImp generator;

    @BeforeAll
    static void beforeAll() {
        generator = new GeneratorImp();
    }

    @Test
    void checkSize_Ok() {
        List<int[][]> towers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            towers.add(generator.getRandomTower());
        }
        for (int[][] matrix : towers) {
            for (int j = 0; j < matrix.length; j++) {
                int[] ints = matrix[j];
                for (int i : ints) {
                    assertNotEquals(i, j);
                }
                assertTrue(ints.length <= 10);
            }
            assertTrue(matrix.length >= 5 && matrix.length <= 20);
        }
    }
}