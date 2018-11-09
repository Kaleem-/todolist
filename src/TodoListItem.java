public class TodoListItem {

    private final String description;
    private final int priority;

    private boolean done = false;

    public TodoListItem(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "description='" + description + '\'' +
                ", priority=" + priority +
                ", done=" + done +
                '}';
    }

    public boolean isIncomplete() {
        return !done;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        done = true;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
