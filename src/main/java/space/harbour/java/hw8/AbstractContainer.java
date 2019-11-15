
public abstract class AbstractContainer {

    private AbstractContainer nextContainer;

    /*
     * A method to chain containers
     */
    public void setNextContainer(final AbstractContainer container) {
        this.nextContainer = container;
    }
    /*
     * A method to withdraw
     */
    public void withdraw(final int amount) {
        int left = returnCash(amount);
        if (left != 0) {
            if (nextContainer != null) {
                nextContainer.withdraw(left);
            }
        }
    }

    abstract int returnCash(int n);
    abstract int getAmountLeft();

}
