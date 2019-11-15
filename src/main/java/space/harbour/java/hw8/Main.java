public final class Main {

    private ATMChain atmChain;
    private Iterator<AbstractContainer> iter;

    public boolean setUp(final int numOfConts) {
        atmChain = new ATMChain();
        atmChain = atmChain.setUp(numOfConts);
        if (atmChain != null) {
            return true;
        }
        return false;
    }


    public int cashLeft() {
        int amount = 0;
        iter = atmChain.getIter();
        while (iter.hasNext()) {
            amount += iter.current().getAmountLeft();
            iter.next();
        }

        return amount;
    }

    public void withdraw(final int amount) {
        if (amount > 0) {
            atmChain.toWithdraw(amount);
        }
    }

}



