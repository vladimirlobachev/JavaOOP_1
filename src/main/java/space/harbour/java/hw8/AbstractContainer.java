
public final abstract class AbstractContainer {

    
    private AbstractContainer nextContainer;

    public void setNextContainer(final AbstractContainer container) {
        this.nextContainer = container;
    }

    public int withdraw(final int amount) {
        int left = returnCash(amount);
        if (left != 0) {
            if (nextContainer != null) {
                nextContainer.withdraw(left);
            }
            else {
                return left;
            }
        }
        
        else {
            return 0;
        }
        return left;
    }

    abstract int returnCash(final int n);
    abstract int getAmountLeft();

}
