public class Main {

    private static ATMChain atmChain;
    private static final MONEY1 = 500;
    private static final MONEY2 = 600;
    private static final NUM_OF_CONTS = 2;

    private Main() { }

    public static void main(final String[] args) {

        var atm = atmChain.setUp(NUM_OF_CONTS);
        System.out.println(atm.head.withdraw(MONEY1));
        //atm.getIterator();
        //atmChain.getIterator();

        var atm = atmChain.setUp(NUM_OF_CONTS);
        System.out.println(atm.head.withdraw(MONEY2));


    }
}
