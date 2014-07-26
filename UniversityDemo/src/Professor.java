public class Professor extends Person {
	public static enum Rank {
		INSTR, ASST, ASSOC, PROF
	}

	private Rank rank;

	public Professor(String name, Rank rank) {
		super(name);
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		String s = "Professor " + this.getName();
		s = s + "\nRank " + this.getRank();
		return s;
	}
}
