public class Main {
    public static void main(String[] args) {
        car myCar = new car("Aston Martin", 900000);

        System.out.println("This car is a " + myCar.oldOrNew()+ " car.");

        base myPorsche = new porsche();
        myPorsche.type();
    }
}
