public final class EstimateSize {

    private EstimateSize() {

    }

    public static final int WAIT_TIME = 10;
	public static final int INT_VALUE = 100;

    public static long getInUse() {
    	long inUse = (Runtime.getRuntime().totalMemory()
    		- Runtime.getRuntime().freeMemory());
	    return  inUse;
	}

    public static void gcJob() {
		System.gc();
		try {
			Thread.sleep(WAIT_TIME);
		} catch (InterruptedException e) {

		}

	}

    public static void declareInt(final long mem) {
		int i = INT_VALUE;
		System.out.println("Size of integer: " + (getInUse() - mem));


	}

    public static void declareString(final long mem) {
		String str = "Hello, World!";
		System.out.println("Size of string: " + (getInUse() - mem));

	}

    public static void declareObj(final long mem) {
		EstimateSize obj = new EstimateSize();
		System.out.println("Size of an object: " + (getInUse() - mem));

	}


    public static void main(String[] args) {

		gcJob();

		System.out.println("Mem in use: " + getInUse());

		declareInt(getInUse());
		gcJob();

		declareString(getInUse());
		gcJob();

		declareObj(getInUse());
		gcJob();
	}
}
