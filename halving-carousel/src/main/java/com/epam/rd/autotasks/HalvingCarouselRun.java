package com.epam.rd.autotasks;
public class HalvingCarouselRun extends CarouselRun{
    public HalvingCarouselRun(int[] container) {
        super(container);
    }
    @Override
    public int next() {
        if (isFinished()){
            return -1;
        } else {
            while (container[position %= container.length] <= 0) {
                position++;
            }
        }
        actions--;
        int returningNumber = container[position];
        container[position] = container[position++] / 2;
        return returningNumber;
    }

    @Override
    public int calculateActions(int[] container) {
        actions = 0;
        for (int elem : container) {
            if (elem != 0) {
                int changingElem = elem;
                while (changingElem != 0) {
                    changingElem /= 2;
                    actions++;
                }
            }
        }
        return actions;
    }
}
