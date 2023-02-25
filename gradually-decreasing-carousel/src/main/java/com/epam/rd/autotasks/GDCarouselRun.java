package com.epam.rd.autotasks;

public class GDCarouselRun extends CarouselRun{
    int mainIncrementIndex = 1;
    int circle = 0;
    public GDCarouselRun(int[] container) {
        super(container);
    }
    @Override
    public int next() {
        if (isFinished()){
            return -1;
        } else {
            while (container[position %= container.length] <= 0) {
                position++;
                circle++;
            }
        }
        if (circle >= container.length) {
            mainIncrementIndex++;
            circle = 0;
        }
        actions--;
        int returningNumber = container[position];
        container[position] = container[position++] - mainIncrementIndex;
        circle++;
        return returningNumber;
    }

    @Override
    public int calculateActions(int[] container) {
        actions = 0;
        for (int elem : container) {
            if (elem != 0) {
                int changingElem = elem;
                int incrementIndex = 1;
                while (changingElem > 0) {
                    changingElem -= incrementIndex;
                    incrementIndex++;
                    actions++;
                }
            }
        }
        return actions;
    }
}
