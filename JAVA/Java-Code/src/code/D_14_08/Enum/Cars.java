package code.D_14_08.Enum;

public class Cars {
	private Level levl;

	private String Model;

	public void createCars(Level levl, String model) {

		this.levl = levl;
		Model = model;
	}

	public Cars() {
		super();
	}

	public Level getLevl() {
		return levl;
	}

	public void setLevl(Level levl) {
		this.levl = levl;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getCar() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t" + getModel() + " is " + getLevl());
		return sb.toString();
	}

}
