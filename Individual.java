package StudentTeacherRecordSystem;

public abstract class Individual {
    protected String name;
    protected String id;

    public Individual(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public abstract String getDetails();
}