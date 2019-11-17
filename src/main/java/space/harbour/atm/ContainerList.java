package space.harbour.atm;

public class ContainerList implements List<AbstractContainer> {
    private AbstractContainer[] containers;

    public ContainerList(final AbstractContainer[] conts) {
        this.containers = conts;
    }


    /*
     * Returns instance of ContainerIterator
     */

    @Override
    public Iterator<AbstractContainer> iterator() {
        return new ContainerIterator(containers);
    }
}
