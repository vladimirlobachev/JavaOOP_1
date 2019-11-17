package space.harbour.atm;

import space.harbour.factory.Prototype;

public final class ATM implements Prototype {

    private ATMChain atmChain;

    private int id;

    public ATM(final int ident) {
        this.id = ident;
    }


    @Override
    public ATM clone() throws CloneNotSupportedException {
        return (ATM) super.clone();
    }


    @Override
    public int getId() {
        return this.id;
    }


    @Override
    public boolean setUp(final int numOfConts) {
        atmChain = new ATMChain();
        atmChain = atmChain.setUp(numOfConts);
        if (atmChain != null) {
            return true;
        }
        return false;
    }


    @Override
    public int cashLeft() {
        int amount = 0;
        Iterator<AbstractContainer> iter = atmChain.getIter();
        while (iter.hasNext()) {
            amount += iter.current().getAmountLeft();
            iter.next();
        }

        return amount;
    }

    @Override
    public void withdraw(final int amount) {
        if (amount > 0) {
            atmChain.toWithdraw(amount);
        }
    }

}



