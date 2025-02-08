public class Meeting extends Tasks{
    private String topic;

    public Meeting(int id, String start, String topic, String project) {
        super(id);
        this.start = start;
        this.topic = topic;
        this.project = project;
    }

    private String project;
    private String start;

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if(topic.contains(query)) {
            return true;
        } else if (project.contains(query)) {
            return true;
        }else {
            return false;
        }
    }
}