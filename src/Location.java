import java.util.Scanner;

public abstract class Location {
    public static Scanner input=new Scanner(System.in);
    private int id;
    private Player player;
    private String name;

    public  Location(int id,Player player,String name){
        this.player=player;
        this.name=name;
        this.id=id;
    }
    public abstract boolean onLocation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
