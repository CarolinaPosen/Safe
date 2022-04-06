package by.mikhalevich.dynamic;

import java.util.ArrayList;
import java.util.List;

public class Safe {

    private Integer capacity;
    private List<Thing> things;

    public Safe(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > Integer.MAX_VALUE)
            initialCapacity = Integer.MAX_VALUE;

        this.things = new ArrayList<>(initialCapacity);
        this.capacity = initialCapacity;

    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

//    public String getDescription() {
//        return things == null ? "" : things.stream().map(Thing::getName).collect(Collectors.joining("+")) + "-" + getGold();
//    }

    @Override
    public String toString() {
        return "Safe{" +
                ", capacity=" + capacity +
                ", things=" + things +
                '}';
    }
}
