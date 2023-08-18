package ca.mcmaster.cas.se2aa4.a4.pathfinder;

public class Node {
    private int id;
    private String name;
    private String cityName;
    private String cityType;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int ID() {
        return this.id;
    }
    public String cityName() {
        return this.cityName;
    }

    public String cityType() {
        return this.cityType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
