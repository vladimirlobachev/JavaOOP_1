package space.harbour.atm;

public final class ContainerIterator implements Iterator<AbstractContainer> {
    private AbstractContainer[] containers;
    private int position;

    public ContainerIterator(final AbstractContainer[] conts) {
        this.containers = conts;
        position = 0;
    }

    @Override
    public AbstractContainer next() {
        return containers[position++];
    }

    @Override
    public AbstractContainer current() {
        return containers[position];
    }

    @Override
    public boolean hasNext() {
        if (position >= containers.length) {
            return false;
        }
        return true;
    }
}
