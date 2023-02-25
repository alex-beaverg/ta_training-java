package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public CarouselRun run(){
        if (isCarouselRun) {
            return null;
        }
        isCarouselRun = true;
        return new GDCarouselRun(container);
    }
}
