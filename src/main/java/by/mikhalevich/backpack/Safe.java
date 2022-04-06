package by.mikhalevich.backpack;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Safe {

    private Thing[] things;
    private Integer price;

    public Safe(Thing[] things, int price) {
        this.things = things;
        this.price = price;
    }

    public Thing[] getItems() {
        return things;
    }

    public int getPrice() {
        return price;
    }

    //Описание состояния рюкзака
    public String getDescription() {
        return things == null ? "" : Arrays.stream(things).map(Thing::getName).collect(Collectors.joining("+")) + "-" + getPrice();
    }
}


