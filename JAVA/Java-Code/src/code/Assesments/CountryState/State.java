package code.Assesments.CountryState;

public class State implements Comparable<State> {

	private String state;

	public State() {
		super();
	}

	public State(String state) {
		super();
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int compareTo(State o) {
		return this.getState().compareTo(o.getState());

	}
}
