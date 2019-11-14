
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
    public void returnCash(final int n) {
        if (getAmountLeft() > 0) {
            if (n >= denom) {
                while (numberOfBills * n != 0) {
                    numberOfBills--;
                    n -= denom;
                }
            }
        }
    }
}
