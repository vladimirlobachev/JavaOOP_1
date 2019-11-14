import java.util.List;
import java.util.ArrayList;


public final class ATMChain {

    private ATMChain() {
    }

    private static final int ARBITRARY_MULT = 10;
    private static final int ARBITRARY_ADD = 1;

    private static AbstractContainer head;
    private static List<AbstractContainer> lc
     = new ArrayList<AbstractContainer>();

    public static void setContainers(final int numOfContainers) {
        for (int i = 0; i < numOfContainers; i++) {
            int arbitrary = (i + ARBITRARY_ADD) * ARBITRARY_MULT;
            lc.add(new Container(arbitrary, arbitrary));
        }
    }

    public static void setChain() {
        AbstractContainer pointer =  null;

        for (AbstractContainer cont: lc) {
            if (head == null) {
                head = cont;
                pointer = cont;
            } else {
                pointer.setNextContainer(cont);
                pointer = cont;
            }
        }
    }

    public static void getIterator() {
        AbstractContainer[] conts = new AbstractContainer[lc.size()];
        for (int i = 0; i < lc.size(); i++) {
            conts[i] = lc.get(i);
        }
        //var list = new AbstractContainerList(conts);
        //return list.iterator();

    }

    public static ATMChain setUp(final int numOfContainers) {
        setContainers(numOfContainers);
        setChain(lc);
        var ourChain = new ATMChain();

        return ourChain;
    }

}
