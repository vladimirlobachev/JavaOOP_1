package space.harbour.atm;

import java.util.Random;

public final class ATMChain {

    private static final int[] RAND_DENOMS =
     new int[] {5, 10, 20, 50, 100, 200, 500};
    private static final int[] RAND_NUMBERS = new int[] {50, 100, 200};

    private AbstractContainer head;
    private AbstractContainer[] containers;

    public void setContainers(final int numOfConts) {
        containers = new AbstractContainer[numOfConts];
        Random random = new Random();
        for (int i = 0; i < containers.length; i++) {
            containers[i] =
                new Container(RAND_DENOMS[random.nextInt(RAND_DENOMS.length)],
                RAND_NUMBERS[random.nextInt(RAND_NUMBERS.length)]);
        }
    }

    public void setChain() {

        AbstractContainer pointer = null;

        for (AbstractContainer cont: containers) {
            if (head == null) {
                head = cont;
                pointer = cont;
            } else {
                pointer.setNextContainer(cont);
                pointer = cont;
            }
        }
    }

    public void toWithdraw(final int amount) {
        head.withdraw(amount);
    }

    public Iterator<AbstractContainer> getIter() {
        List<AbstractContainer> list = new ContainerList(containers);
        return list.iterator();
    }


    public ATMChain setUp(final int numOfConts) {
        if (numOfConts > 0) {
            setContainers(numOfConts);
            setChain();
            return this;
        } else {
            return null;
        }
    }
}
