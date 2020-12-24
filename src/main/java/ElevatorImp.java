import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElevatorImp implements Elevator {
    private List<Integer> elevator;
    private int floor;
    private int aim;
    private Direction direction;

    public ElevatorImp() {
        this.elevator = new ArrayList<>();
        this.floor = 0;
        direction = Direction.UP;
    }

    public List<Integer> getElevator() {
        return elevator;
    }

    @Override
    public void startWork(Tower tower) {
        int[][] localTower = tower.getTower();
        System.out.println("Number of floors: " + (localTower.length - 1));
        System.out.println();
        while (contains(localTower) || elevator.size() != 0) {
            for (int i = 0; i < localTower[floor].length; i++) {
                if (elevator.size() == 0 && localTower[floor][i] != -1) {
                    elevator.add(localTower[floor][i]);
                    aim = localTower[floor][i];
                    localTower[floor][i] = -1;
                    findDirection();
                }
                if (elevator.size() < 5 && localTower[floor][i] != -1
                        && (direction == Direction.UP && localTower[floor][i] > floor
                        || direction == Direction.DOWN && localTower[floor][i] < floor)) {
                    elevator.add(localTower[floor][i]);
                    aim = direction == Direction.DOWN ? Math.min(localTower[floor][i], aim)
                            : Math.max(localTower[floor][i], aim);
                    localTower[floor][i] = -1;
                }
            }
            delay(1);
            System.out.printf("Current floor: %2d %40s, elevator: %18s, aim floor:%d \n",
                    floor, Arrays.toString(localTower[floor]), elevator, aim);
            step();
            removeAll(floor);
            if (elevator.size() == 0) {
                findPeople(localTower);
            }
        }
        System.out.println();
        System.out.println("People in elevator: " + elevator);
        System.out.println();
        for (int i = 0; i < localTower.length; i++) {
            int[] ints = localTower[i];
            System.out.println("Floor #" + i + Arrays.toString(ints));
        }
    }

    private static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void findPeople(int[][] localTower) {
        while (!contains(localTower[floor])) {
            if (floor == 0) {
                direction = Direction.UP;
            }
            if (floor == localTower.length - 1) {
                direction = Direction.DOWN;
            }
            if (!contains(localTower)) {
                break;
            }
            step();
        }
    }

    private void removeAll(int floor) {
        while (elevator.remove(Integer.valueOf(floor))) {
        }
    }

    private void step() {
        if (direction == Direction.DOWN) {
            floor--;
        } else {
            floor++;
        }
    }

    private void findDirection() {
        if (aim > floor) {
            direction = Direction.UP;
        } else {
            direction = Direction.DOWN;
        }
    }

    private boolean contains(int[][] tower) {
        for (int[] ints : tower) {
            for (int anInt : ints) {
                if (anInt != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean contains(int[] floor) {
        for (int anInt : floor) {
            if (anInt != -1) {
                return true;
            }
        }
        return false;
    }
}
