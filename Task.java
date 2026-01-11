package Task;

public class Task {
    private String taskDes;
private String status;
    public Task(String taskDes){
        this.taskDes=taskDes;
    }

    public String getTaskDes() {
        return taskDes;
    }
    public void setTaskDes(String td){
        this.taskDes=td;
    }
      public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

