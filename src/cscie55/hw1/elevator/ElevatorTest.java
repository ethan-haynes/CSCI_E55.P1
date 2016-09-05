package cscie55.hw1.elevator;

class ElevatorTest {

    public static void main(String[] args) {
        Elevator el = new Elevator();

        el.boardPassenger(3);
        el.boardPassenger(3);
        el.boardPassenger(5);
        System.out.println(el);

        for (int i = 0; i < 12; i++) {
            el.move();
            System.out.println(el);
        }
    }
}
