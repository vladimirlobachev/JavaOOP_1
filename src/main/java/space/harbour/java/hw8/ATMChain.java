public final class ATMChain {

    private static final int ARBITRARYMULT = 10;
    private static final int ARBITRARYADD = 1;

    private int numOfContainers = 0;

    private AbstractContainer head;
    private AbstractContainer[] containers;

    public void setContainers() {
        containers = new AbstractContainer[this.numOfContainers];
        for (int i = 0; i < containers.length; i++) {
            int arbitrary = (i + ARBITRARYADD) * ARBITRARYMULT;
            containers[i] = new Container(arbitrary, arbitrary);
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
        System.out.println(head == null);
        head.withdraw(amount);
    }

    public Iterator<AbstractContainer> getIter() {
        List<AbstractContainer> list = new ContainerList(containers);
        return list.iterator();
    }


    public ATMChain setUp(final int numOfConts) {
        if (numOfConts > 0) {
            this.numOfContainers = numOfConts;
            setContainers();
            setChain();
            return this;
        } else {
            return null;
        }
    }
}
