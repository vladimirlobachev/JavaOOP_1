package space.harbour.factory;

import java.util.List;
import java.util.ArrayList;

import space.harbour.atm.ATM;

public class Factory {


    /*
    *
    * to Clone many ATMS
    *
    */

    public List<Prototype> cloneATM(final int numOfClones) {

        if (numOfClones == 0) {
            return null;
        }

        List<Prototype> lp = new ArrayList<Prototype>();

        try {
            for (int i = 0; i < numOfClones; i++) {
                lp.add(getInstance(new ATM(i)));
            }
            return lp;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Prototype getInstance(final ATM atm)
     throws CloneNotSupportedException {
        return ((Prototype) atm).clone();
    }

}
