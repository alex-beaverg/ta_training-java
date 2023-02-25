package com.epam.rd.autotasks;

public class DecrementingCarousel {
    int[] container;
    boolean isCarouselRun = false;
    int actionLimit;
    public DecrementingCarousel(int capacity) {
        container = new int[capacity];
    }

    public boolean addElement(int element){
        if (isCarouselRun == false && element > 0) {
            for (int i = 0; i < container.length; i++) {
                if (container[i] == 0) {
                    container[i] = element;
                    return true;
                }
            }
        }
        return false;
    }

    public CarouselRun run(){
        if (isCarouselRun) {
            return null;
        }
        isCarouselRun = true;
        return new CarouselRun(container, actionLimit);
    }
}
