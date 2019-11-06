public class EstimateSize {

	public static long getInUse() {
	return  Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	public static void gcJob() {
		System.gc();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {

		}

	}

	public static void declareInt(long mem) {
		int i = 123;
		System.out.println("Size of integer: " + (getInUse() - mem));


	}

	public static void declareString(long mem) {
		String str = "Hello, World!";
		System.out.println("Size of string: " + (getInUse() - mem));

	}

	public static void declareObj(long mem) {
		EstimateSize obj = new EstimateSize();
		System.out.println("Size of an object: " + (getInUse() - mem));

	}


	public static void main(String[] args) {

		gcJob();

		System.out.println("Total: " + Runtime.getRuntime().totalMemory());
		System.out.println("Free: " + Runtime.getRuntime().freeMemory());
		System.out.println("Mem in use: " + getInUse());

		declareInt(getInUse());
		gcJob();

		declareString(getInUse());
		gcJob();

		declareObj(getInUse());
		gcJob();
		
	}
}