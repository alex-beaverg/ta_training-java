package com.epam.rd.autotasks;

public class TaskCarousel {
    private Task[] taskList;
    private int position = 0;
    public TaskCarousel(int capacity) {
        taskList = new Task[capacity];
    }
    public boolean addTask(Task task) {
        if (task.getValue() != 0 && !task.isFinished() && !isFull()) {
            for (int i = 0; i < taskList.length; i++) {
                if (taskList[i] == null) {
                    taskList[i] = task;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean execute() {
        if (isEmpty()){
            return false;
        } else {
            while (taskList[position %= taskList.length] == null) {
                position++;
            }
        }
        taskList[position].execute();
        if (taskList[position].isFinished()) {
            taskList[position] = null;
        }
        position++;
        return true;
    }
    public boolean isFull() {
        for (Task task : taskList) {
            if (task == null) return false;
        }
        return true;
    }
    public boolean isEmpty() {
        for (Task task : taskList) {
            if (task != null) return false;
        }
        return true;
    }
}
