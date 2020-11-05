package blatt04.tasklist;

/** Task with priority and description */
public class Task {
	private Priority prio;
	private String description;
	
	public Task(Priority prio, String description) {
		this.prio = prio;
		this.description = description;
	}
	
	public String toString() {
		return description + " (" + prio + ")";
	}

	public Priority getPriority() {
		return prio;
	}

	public String getDescription() {
		return description;
	}
	
	
}