package Duke.Duke;

public class CtoJava {
    protected String description;
    protected boolean isDone;
    public CtoJava(String description)
    {
        this.description = description;
        this.isDone = false;
    }
    public Void Check(String done){
        if(done.equals("done") == true) {
            this.isDone = true;
        }
        return null;
    }
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    public class Deadline extends CtoJava {

        protected String by;

        public Deadline(String description, String by) {
            super(description);
            this.by = by;
        }

        @Override
        public String toString() {
            return "[D]" + super.toString() + " (by: " + by + ")";
        }
    }
    public class Event extends CtoJava {

        protected String at;

        public Event(String description, String at) {
            super(description);
            this.at = at;
        }

        @Override
        public String toString() {
            return "[E]" + super.toString() + " (at: " + at + ")";
        }
    }
}
