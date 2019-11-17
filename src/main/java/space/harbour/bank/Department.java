package space.harbour.bank;

import java.util.List;

import space.harbour.factory.Prototype;
import space.harbour.factory.Factory;


public final class Department {

    private static final int ATM_SETUP = 5;
    private static final Factory FACTORY = new Factory();
    private List<Prototype> atms;

    public boolean newATMs(final int numOfAtms) {
        if (numOfAtms > 0) {
            atms = FACTORY.cloneATM(numOfAtms);
            setATMs();
            return true;
        }
        return false;
    }

    private void setATMs() {
        for (Prototype atm: atms) {
            atm.setUp(ATM_SETUP);
        }
    }

    public Prototype getATM(final int id) {
        for (Prototype atm: atms) {
            if (atm.getId() == id) {
                return atm;
            }
        }
        return null;
    }

}
