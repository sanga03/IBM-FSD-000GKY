package code.D_14_08.Enum;

public enum Level {

	AWESOM(10), BEST(8), BETTER(7), GOOD(6), AVERAGE(5), POOR(3);

	int levlCode;

	private Level(int levlCode) {
		this.levlCode = levlCode;
	}

}
