import java.util.Random;

public class GeneratorImp implements Generator {

    private int[] getRandomFloor(int numberOfFloor, int maxFloors) {
        int[] floor = new int[new Random().nextInt(11)];
        for (int i = 0; i < floor.length; i++) {
            int neededFloor = new Random().nextInt(maxFloors + 1);
            while (neededFloor == numberOfFloor) {
                neededFloor = new Random().nextInt(maxFloors + 1);
            }
            floor[i] = neededFloor;
        }
        return floor;
    }

    @Override
    public int[][] getRandomTower() {
        int[][] tower = new int[5 + new Random().nextInt(16)][];
        for (int i = 0; i < tower.length; i++) {
            tower[i] = getRandomFloor(i, tower.length - 1);
        }
        return tower;
    }
}
