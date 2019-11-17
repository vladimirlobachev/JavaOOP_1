package space.harbour.atm;

public final class Container extends AbstractContainer {


    private int denom;
    private int numberOfBills;

    public Container(final int den, final int numOfBills) {
        this.denom = den;
        this.numberOfBills = numOfBills;
    }

    @Override
    public int getAmountLeft() {
        return denom * numberOfBills;
    }

    @Override
    public int returnCash(final int n) {
        int iDontWantMyNToBeFinal = n;
        if (getAmountLeft() > 0) {
            if (iDontWantMyNToBeFinal >= denom) {
                while (numberOfBills * iDontWantMyNToBeFinal != 0) {
                    numberOfBills--;
                    iDontWantMyNToBeFinal -= denom;
                }
                return iDontWantMyNToBeFinal;
            }
        }
        return iDontWantMyNToBeFinal;
    }
}
