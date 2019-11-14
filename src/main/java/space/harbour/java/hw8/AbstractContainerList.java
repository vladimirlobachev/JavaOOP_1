import java.util.List;

public final class AbstractContainerList implements List<AbstractContainer> {

    private AbstractContainer[] containers;

    public AbstractContainerList(final AbstractContainerList[] conts) {
        this.containers = conts;
    }

    @Override
    public Iterator<AbstractContainerList> iterator() {
        return new ContainerIterator(containers);
    }
}
