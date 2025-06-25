public class Main {
    public static void main(String[] args) {
        car myCar = new car("Aston Martin", 900000);

        System.out.println(myCar.oldOrNew());

        base myPorsche = new porsche();
        myPorsche.type();
    }
}
