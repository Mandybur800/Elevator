import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorImpTest {
    private static Tower tower;
    private static int[][] emptyTower;
    @BeforeAll
    static void beforeAll() {
        int[][] littleTower = new int[][]{
                {1,2,2,1,1},
                {0,0,2,0,2},
                {1,0,1,0,0}
        };
        emptyTower = new int[][]{
                {-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1}
        };
        tower = new Tower();
        tower.setTower(littleTower);
        tower.getElevator().startWork(tower);
    }

    @Test
    void startWork_Ok() {
        int[][] actualTower= tower.getTower();
        for (int i = 0; i < emptyTower.length; i++) {
            for (int j = 0; j < emptyTower[i].length; j++) {
                assertEquals(emptyTower[i][j], actualTower[i][j]);
            }
        }
        assertEquals(0, tower.getElevator().getElevator().size());
    }
}