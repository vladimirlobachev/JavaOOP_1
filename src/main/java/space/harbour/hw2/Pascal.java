public final class Pascal {

    private Pascal() {
        // stop thworing errors
	}

    private static int getArg(String[] args) {
		try {
			int i = Integer.parseInt(args[0]);
			return i;
		} catch (Exception e) {
			return 0;
		}
	}

    private static int getCoeff(final int i, final int j) {
		int res = 1;

		if (j > i - j) {
			j = i - j;
		}

		for (int k = 0; k < j; k++) {
			res *= (i - k);
			res /= (k + 1);
		}

		return res;
	}

    public static void printPascal(final int n) {

		for (int i = 0; i < n; i++) {
			String res = "";
			for (int j = 0; j <= i; j++) {
				res += getCoeff(i, j);
			}
			System.out.println(res);
		}
	}


	public static void main(String[] args) {
		printPascal(getArg(args));
	}

}
