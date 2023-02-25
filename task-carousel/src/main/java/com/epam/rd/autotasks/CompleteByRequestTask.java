package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    int flag = 0;
    private boolean stop = false;
    @Override
    public void execute() {
        if (flag == 1) {
            stop = true;
        }
    }
    @Override
    public boolean isFinished() {
        return stop;
    }
    public void complete() {
        flag = 1;
    }
}
