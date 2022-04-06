package by.mikhalevich.stream;

import by.mikhalevich.stream.Thing;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Safe {

    private Thing[] things;


    public Safe(Thing[] things) {
        this.things = things;
    }

    public Thing[] getItems() {
        return things;
    }

    @Override
    public String toString() {
        return "Safe{" +
                "things=" + Arrays.toString(things) +
                '}';
    }

    //Описание состояния рюкзака
//    public String getDescription() {
//        return things == null ? "" : Arrays.stream(things).map(Thing::getName).collect(Collectors.joining("+")) + "-" + getPrice();
//    }

}
