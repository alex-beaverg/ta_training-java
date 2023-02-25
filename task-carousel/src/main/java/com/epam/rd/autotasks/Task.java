package com.epam.rd.autotasks;

public interface Task {
    void execute();
    boolean isFinished();
    default int getValue(){
        return 1;
    }
}
