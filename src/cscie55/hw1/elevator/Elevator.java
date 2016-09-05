package cscie55.hw1.elevator;

public class Elevator {
    private static final int FLOORS = 7;
    private int currentFloor;
    private Boolean isTravelingUp;
    private int[] pssngrList = new int[FLOORS];

    public Elevator() {
        this.currentFloor = 1; // first floor
        this.isTravelingUp = true;
    }

    public void move() {
        // if we are traveling up, increment; else, decrement
        currentFloor = (isTravelingUp) ? ++currentFloor : --currentFloor;

        // flip the boolean if we reach either end
        if (currentFloor == 1 || currentFloor == FLOORS) {
            isTravelingUp = !isTravelingUp;
        }

        // remove all passengers at their destination
        pssngrList[currentFloor - 1] = 0;
    }

    public void boardPassenger(int floor) {
        if (7 < floor || floor < 1) // floor out of range
            throw new IllegalArgumentException("Floor is not valid!");

        pssngrList[--floor] += 1; //increment number of pssngrs by 1
    }

    private int totalPassengers() {
        int tp = 0;

        for (int pssngr : pssngrList) {
            tp += pssngr;
        }

        return tp;
    }

    @Override
    public String toString() {
        return String.format("Floor %d: %d passengers", currentFloor, totalPassengers());
    }
}
