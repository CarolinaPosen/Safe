package by.mikhalevich.dynamic;

public class Thing implements Comparable<Thing>{

    private String name;
    private Integer volume;
    private Integer gold;

    public Thing(String name, Integer volume, Integer gold) {
        this.name = name;
        this.volume = volume;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    @Override
    public int compareTo(Thing t) {
        return Integer.compare(gold, t.gold);
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", gold=" + gold +
                '}';
    }
}
