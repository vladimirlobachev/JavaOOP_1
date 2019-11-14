public final class Main {

    private static ATMChain atmChain;
    private static final int TO_WITHDRAW_ONE = 500;
    private static final int TO_WITHDRAW_TWO = 600;
    private static final int NUM_OF_CONTS = 2;

    private Main() { }

    public static void main(final String[] args) {

        var atm = atmChain.setUp(NUM_OF_CONTS);
        System.out.println(atm.head.withdraw(TO_WITHDRAW_ONE));
        //atm.getIterator();
        //atmChain.getIterator();

        var atm = atmChain.setUp(NUM_OF_CONTS);
        System.out.println(atm.head.withdraw(TO_WITHDRAW_TWO));


    }
}
