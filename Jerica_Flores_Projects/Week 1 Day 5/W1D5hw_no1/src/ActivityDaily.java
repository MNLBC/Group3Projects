
public enum ActivityDaily {

	Mon("Attend monday class"), Tue("Go to gym"), Wed("Go to market"), Thu("Go to the mall and shop"), Fri("Visit parents"), Sat(
			"Have lunch with friends"), Sun("Go to church");

	private String dayVal;

	ActivityDaily(String dayVal) {
		this.dayVal = dayVal;
	}

	@Override
	public String toString() {
		return this.dayVal;
	}
	}