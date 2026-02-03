package Game;

import java.util.Arrays;

public class Task {
    private String taskId;
    private String parentId;
    private String description;
    private boolean completed;
    private String[] correctAnswers;

    public Task() {
    }

    public void complete(){}
    public String getDescription(){return this.description;}
    public boolean isCompleted(){return this.completed;}
    public String[] getCorrectAnswers(){return this.correctAnswers;}

    public String getTaskId() {
        return taskId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCorrectAnswers(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", correctAnswers=" + Arrays.toString(correctAnswers) +
                '}';
    }
}
