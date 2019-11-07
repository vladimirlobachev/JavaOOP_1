public class EstimateSize {

	private EstimateSize() {

	}

	public static final int WAIT_TIME=10;

    public static long getInUse() {
    	long inUse = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	    return  inUse;
	}

    public static void gcJob() {
		System.gc();
		try {
			Thread.sleep(WAIT_TIME);
		} catch (InterruptedException e) {

		}

	}

    public static final void declareInt(long mem) {
		int i = WAIT_TIME*10;
		System.out.println("Size of integer: " + (getInUse() - mem));


	}

    public static final void declareString(long mem) {
		String str = "Hello, World!";
		System.out.println("Size of string: " + (getInUse() - mem));

	}

    public static final void declareObj(long mem) {
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
