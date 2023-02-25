package com.epam.rd.autotasks;

public class CarouselRun {
    int[] container;
    int position = 0;
    int actions = 1;
    public CarouselRun(int[] container) {
        this.container = container;
        actions = calculateActions(container);
    }

    public int next() {
        if (isFinished()){
            return -1;
        } else {
            while (container[position %= container.length] <= 0) {
                position++;
            }
        }
        actions--;
        return container[position++]--;
    }

    public boolean isFinished() {
        if (actions == 0){
            return true;
        }
        else {
            for (int i : container) {
                if (i > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int calculateActions(int[] container) {
        for (int elem : container) {
            if (elem != 0) {
                actions *= elem;
            }
        }
        return actions;
    }
}
