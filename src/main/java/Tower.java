public class Tower {
    private ElevatorImp elevator;
    private int[][] tower;

    public Tower() {
        this.elevator = new ElevatorImp();
        this.tower = new GeneratorImp().getRandomTower();
    }

    public ElevatorImp getElevator() {
        return elevator;
    }

    public int[][] getTower() {
        return tower;
    }

    public void setTower(int[][] tower) {
        this.tower = tower;
    }
}
