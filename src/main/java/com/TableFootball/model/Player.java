package main.java.com.TableFootball.model;

public class Player {

    private int id;
    private String name;
    private boolean is_active;


    public Player(int playerid, String name, boolean is_active) {
        this.id = playerid;
        this.name = name;
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", is_active=" + is_active +
                '}';
    }
}
